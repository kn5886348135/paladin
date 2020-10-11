package com.paladin.account.service.impl;

import com.paladin.account.entity.RolePermissionRelation;
import com.paladin.account.mapper.RolePermissionRelationMapper;
import com.paladin.account.service.IRolePermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户角色和权限关系表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class RolePermissionRelationServiceImpl extends ServiceImpl<RolePermissionRelationMapper,
		RolePermissionRelation> implements IRolePermissionRelationService {

}
