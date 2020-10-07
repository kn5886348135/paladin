package com.paladin.account.service.impl;

import com.paladin.account.entity.MemberTagRelation;
import com.paladin.account.mapper.MemberTagRelationMapper;
import com.paladin.account.service.IMemberTagRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和标签关系表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class MemberTagRelationServiceImpl extends ServiceImpl<MemberTagRelationMapper, MemberTagRelation> implements IMemberTagRelationService {

}
