package com.paladin.account.service;

import com.paladin.account.entity.AdminPermissionRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
public interface IAdminPermissionRelationService extends IService<AdminPermissionRelation> {

}
