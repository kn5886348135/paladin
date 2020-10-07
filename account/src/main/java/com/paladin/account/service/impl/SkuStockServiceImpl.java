package com.paladin.account.service.impl;

import com.paladin.account.entity.SkuStock;
import com.paladin.account.mapper.SkuStockMapper;
import com.paladin.account.service.ISkuStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class SkuStockServiceImpl extends ServiceImpl<SkuStockMapper, SkuStock> implements ISkuStockService {

}
