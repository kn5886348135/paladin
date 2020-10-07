package com.paladin.account.service.impl;

import com.paladin.account.entity.RolePerm;
import com.paladin.account.mapper.RolePermMapper;
import com.paladin.account.service.IRolePermService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class RolePermServiceImpl extends ServiceImpl<RolePermMapper, RolePerm> implements IRolePermService {

}
