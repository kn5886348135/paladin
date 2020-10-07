package com.paladin.account.service.impl;

import com.paladin.account.entity.ProductLadder;
import com.paladin.account.mapper.ProductLadderMapper;
import com.paladin.account.service.IProductLadderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class ProductLadderServiceImpl extends ServiceImpl<ProductLadderMapper, ProductLadder> implements IProductLadderService {

}
