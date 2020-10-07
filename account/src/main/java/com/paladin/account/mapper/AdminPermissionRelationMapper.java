package com.paladin.account.mapper;

import com.paladin.account.entity.AdminPermissionRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) Mapper 接口
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
public interface AdminPermissionRelationMapper extends BaseMapper<AdminPermissionRelation> {

}
