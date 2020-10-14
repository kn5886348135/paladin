package com.paladin.account.service;

import com.paladin.account.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
public interface IAccountService extends IService<Account> {

	public boolean register(Account account);

	boolean login(String accountName, String password);
}
