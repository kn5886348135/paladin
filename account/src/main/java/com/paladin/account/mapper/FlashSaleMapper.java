package com.paladin.account.mapper;

import com.paladin.account.entity.FlashSale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paladin.account.entity.HomeFlashSale;

import java.util.List;

/**
 * <p>
 * 秒杀商品 Mapper 接口
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
public interface FlashSaleMapper extends BaseMapper<FlashSale> {
    List<HomeFlashSale> selectHomeFlashsaleList();
}
