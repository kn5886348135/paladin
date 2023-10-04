package com.paladin.account.service;

import com.paladin.account.entity.FlashSale;
import com.baomidou.mybatisplus.extension.service.IService;
import com.paladin.account.entity.HomeFlashSale;

import java.util.List;

/**
 * <p>
 * 秒杀商品 服务类
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
public interface IFlashSaleService extends IService<FlashSale> {

    List<HomeFlashSale> findHomeFlashSaleList();
}
