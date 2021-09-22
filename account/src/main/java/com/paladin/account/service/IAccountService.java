package com.paladin.account.service;

import com.paladin.account.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
public interface IAccountService extends IService<Account> {

	String register(Account account);

	boolean login(String accountName, String passwd);

	/**
	 * 生成验证码，使用{@link java.security.SecureRandom}或者{@link java.util.concurrent.ThreadLocalRandom}
	 * 生成强密码截取前六位
	 *
	 * @param username 用户名
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	String getVerifyCode(String username);
}
