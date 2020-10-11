package com.paladin.account.service.impl;

import com.paladin.account.entity.MemberProductCategoryRelation;
import com.paladin.account.mapper.MemberProductCategoryRelationMapper;
import com.paladin.account.service.IMemberProductCategoryRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员与产品分类关系表（用户喜欢的分类） 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class MemberProductCategoryRelationServiceImpl extends ServiceImpl<MemberProductCategoryRelationMapper,
		MemberProductCategoryRelation> implements IMemberProductCategoryRelationService {

}
