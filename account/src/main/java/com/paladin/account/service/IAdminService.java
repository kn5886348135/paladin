package com.paladin.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.paladin.account.entity.Admin;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
public interface IAdminService extends IService<Admin> {

	boolean adminLogin(String username, String passwd);
}
