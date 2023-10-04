package com.paladin.account.service.impl;

import com.paladin.account.entity.Shop;
import com.paladin.account.mapper.ShopMapper;
import com.paladin.account.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀商品 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

}
