package com.paladin.account.mapper;

import com.paladin.account.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
public interface AdminMapper extends BaseMapper<Admin> {

	Admin selectAdminByUsernameAndPasswd(@Param("username") String username, @Param("passwd") String passwd);
}
