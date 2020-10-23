package com.paladin.account.service.impl;

import com.paladin.account.entity.Admin;
import com.paladin.account.mapper.AdminMapper;
import com.paladin.account.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public boolean adminLogin(String username, String passwd) {
		Admin admin = adminMapper.selectAdminByUsernameAndPasswd(username, passwd);
		if (admin == null) {
			return false;
		}
		return true;
	}
}
