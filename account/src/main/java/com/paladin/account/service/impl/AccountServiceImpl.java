package com.paladin.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paladin.account.entity.Account;
import com.paladin.account.mapper.AccountMapper;
import com.paladin.account.service.IAccountService;
import com.paladin.account.util.Constants;
import com.paladin.account.util.MD5Utils;
import io.rebloom.client.Client;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	private AccountMapper accountMapper;

	private RedisTemplate redisTemplate;

	public AccountServiceImpl(AccountMapper accountMapper, RedisTemplate redisTemplate) {
		this.accountMapper = accountMapper;
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String register(Account account) {
		String passwd = account.getPasswd();
		// 密码加密
		passwd = passwd + Constants.salt;
		passwd = MD5Utils.md5Sign(passwd);
		account.setPasswd(passwd);
		Object verifyCode = redisTemplate.opsForValue().get(account.getAccountName());
		if (ObjectUtils.isEmpty(verifyCode)) {
			return "验证码失效";
		}
		if (!verifyCode.toString().equals(account.getCode())) {
			return "验证码错误";
		}

		// 用户名去重,可以加载redis的bloom模块，使用bloom Filter实现
		Account accountQueryWrapper = new Account();
		accountQueryWrapper.setAccountName(account.getAccountName());
		List<Account> accountList = list(new QueryWrapper<>(accountQueryWrapper));
		if (accountList != null || accountList.size() > 0) {
			return "用户名已经存在";
		}
		boolean result = save(account);
		return result ? "注册成功" : "注册失败";
	}

	@Override
	public boolean login(String accountName, String passwd) {
		Account account = new Account();
		passwd = passwd + Constants.salt;
		passwd = MD5Utils.md5Sign(passwd);
		account.setAccountName(accountName);
		account.setPasswd(passwd);
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("account_name", accountName);
		columnMap.put("passwd", passwd);
		List<Account> accountlis = listByMap(columnMap);

		return accountlis.size() == 1 ? true : false;
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

}
