package com.paladin.account.service.impl;

import com.paladin.account.entity.AdminPermissionRelation;
import com.paladin.account.mapper.AdminPermissionRelationMapper;
import com.paladin.account.service.IAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class AdminPermissionRelationServiceImpl extends ServiceImpl<AdminPermissionRelationMapper,
		AdminPermissionRelation> implements IAdminPermissionRelationService {

}
