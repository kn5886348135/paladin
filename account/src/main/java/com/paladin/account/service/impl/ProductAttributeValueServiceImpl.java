package com.paladin.account.service.impl;

import com.paladin.account.entity.ProductAttributeValue;
import com.paladin.account.mapper.ProductAttributeValueMapper;
import com.paladin.account.service.IProductAttributeValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储产品参数信息的表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class ProductAttributeValueServiceImpl extends ServiceImpl<ProductAttributeValueMapper, ProductAttributeValue> implements IProductAttributeValueService {

}
