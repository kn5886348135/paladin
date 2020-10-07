package com.paladin.account.service.impl;

import com.paladin.account.entity.AdminRoleRelation;
import com.paladin.account.mapper.AdminRoleRelationMapper;
import com.paladin.account.service.IAdminRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class AdminRoleRelationServiceImpl extends ServiceImpl<AdminRoleRelationMapper, AdminRoleRelation> implements IAdminRoleRelationService {

}
