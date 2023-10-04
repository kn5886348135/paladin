package com.paladin.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paladin.account.entity.Account;
import com.paladin.account.mapper.AccountMapper;
import com.paladin.account.service.IAccountService;
import com.paladin.account.util.message.MessageEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Service
@Validated
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	private RedisTemplate redisTemplate;

	private MessageSource messageSource;

	public AccountServiceImpl(RedisTemplate redisTemplate, MessageSource messageSource) {
		this.redisTemplate = redisTemplate;
		this.messageSource = messageSource;
	}

	@Override
	public String register(Account account) throws NoSuchAlgorithmException{
		String passwd = account.getPasswd();
		// 密码加密
		// passwd = passwd + Constants.salt;
		passwd = digestSHA256(passwd);
		account.setPasswd(passwd);
		Object verifyCode = redisTemplate.opsForValue().get(account.getAccountName());
		if (ObjectUtils.isEmpty(verifyCode)) {
			return messageSource.getMessage(MessageEnum.REGISTER_VERIFY_CODE_MISS.getKey(), null, LocaleContextHolder.getLocale());
		}
		if (!verifyCode.toString().equals(account.getCode())) {
			return messageSource.getMessage(MessageEnum.REGISTER_VERIFY_CODE_ERROR.getKey(), null, LocaleContextHolder.getLocale());
		}

		// 用户名去重,可以加载redis的bloom模块，使用bloom Filter实现
		// Client client = new Client(jedis);
		// client.exists(account.getAccountName(), account.getCode());
		Account accountQueryWrapper = new Account();
		accountQueryWrapper.setAccountName(account.getAccountName());
		// 自动填充主键为0
		List<Account> accountList = list(new QueryWrapper<>(accountQueryWrapper));
		if (CollectionUtils.isNotEmpty(accountList)) {
			return messageSource.getMessage(MessageEnum.REGISTER_USERNAME_EXIST.getKey(), null, LocaleContextHolder.getLocale());
		}

		return save(account) ? messageSource.getMessage(MessageEnum.REGISTER_SUCCESS.getKey(), null,
				LocaleContextHolder.getLocale()) : messageSource.getMessage(MessageEnum.REGISTER_FAILED.getKey(), null
				, LocaleContextHolder.getLocale());
	}

	@Override
	public String login(String accountName, String passwd) {
		Account account = new Account();
//		passwd = passwd + Constants.salt;
//		passwd = MD5Utils.md5Sign(passwd);
		account.setAccountName(accountName);
		account.setPasswd(passwd);
		LOGGER.info("passwd is {}", passwd);
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("account_name", accountName);
		columnMap.put("passwd", passwd);
		List<Account> accountlis = listByMap(columnMap);

		return accountlis.size() == 1 ? messageSource.getMessage(MessageEnum.LOGIN_SUCCESS.getKey(), null,
				LocaleContextHolder.getLocale()) : messageSource.getMessage(MessageEnum.LOGIN_FAILED.getKey(), null,
				LocaleContextHolder.getLocale());
	}

	@Override
	public String logout(String accountName, String passwd) {
		return null;
	}

	@Override
	public String getVerifyCode(String username)  {
		// 考虑加入频率限制
		Object verifyCode = redisTemplate.opsForValue().get(username);

		if (ObjectUtils.isEmpty(verifyCode)) {
			Integer random = ThreadLocalRandom.current().nextInt(100000, 999999);
			redisTemplate.opsForValue().set(username, random, 60, TimeUnit.SECONDS);
			verifyCode = random;
		}
		return verifyCode.toString();
	}

	private static String digestSHA256(String str) throws NoSuchAlgorithmException {
		MessageDigest messageDigest;
		String encodeStr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
			StringBuilder stringBuilder = new StringBuilder();
			String temp;
			byte[] bytes = messageDigest.digest();
			for (byte aByte : bytes) {
				temp = Integer.toHexString(aByte & 0xFF);
				if (temp.length() == 1) {
					//1得到一位的进行补0操作
					stringBuilder.append("0");
				}
				stringBuilder.append(temp);
			}
			return stringBuilder.toString();
		} catch (NoSuchAlgorithmException exp) {
			LOGGER.error(" no such algorithm exception {}", exp);
			throw exp;
		}
	}

}
