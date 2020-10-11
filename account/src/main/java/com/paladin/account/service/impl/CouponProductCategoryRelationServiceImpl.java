package com.paladin.account.service.impl;

import com.paladin.account.entity.CouponProductCategoryRelation;
import com.paladin.account.mapper.CouponProductCategoryRelationMapper;
import com.paladin.account.service.ICouponProductCategoryRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券和产品分类关系表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class CouponProductCategoryRelationServiceImpl extends ServiceImpl<CouponProductCategoryRelationMapper,
		CouponProductCategoryRelation> implements ICouponProductCategoryRelationService {

}
