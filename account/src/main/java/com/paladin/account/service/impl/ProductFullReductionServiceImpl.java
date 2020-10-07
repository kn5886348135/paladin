package com.paladin.account.service.impl;

import com.paladin.account.entity.ProductFullReduction;
import com.paladin.account.mapper.ProductFullReductionMapper;
import com.paladin.account.service.IProductFullReductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品满减表(只针对同商品) 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class ProductFullReductionServiceImpl extends ServiceImpl<ProductFullReductionMapper, ProductFullReduction> implements IProductFullReductionService {

}
