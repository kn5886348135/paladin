package com.paladin.account.service.impl;

import com.paladin.account.entity.ProductAttribute;
import com.paladin.account.mapper.ProductAttributeMapper;
import com.paladin.account.service.IProductAttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements IProductAttributeService {

}
