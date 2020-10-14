package com.paladin.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paladin.account.entity.Account;
import com.paladin.account.mapper.AccountMapper;
import com.paladin.account.service.IAccountService;
import com.paladin.account.util.Constants;
import com.paladin.account.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

	@Resource
	private AccountMapper accountMapper;

	@Override
	public boolean register(Account account) {
		String password = account.getPassword();
		// 密码加密
		password = password + Constants.salt;
		password = MD5Utils.md5Sign(password);
		account.setPassword(password);
		// 用户名去重
		Account accountQueryWrapper = new Account();
		accountQueryWrapper.setAccountName(account.getAccountName());
		List<Account> accountList = list(new QueryWrapper<>(accountQueryWrapper));
		if (accountList != null || accountList.size() > 0) {
			return false;
		}
		boolean result = save(account);

		return result;
	}

}
