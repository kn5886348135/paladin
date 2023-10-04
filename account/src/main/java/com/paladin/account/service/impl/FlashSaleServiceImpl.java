package com.paladin.account.service.impl;

import com.paladin.account.entity.FlashSale;
import com.paladin.account.entity.HomeFlashSale;
import com.paladin.account.mapper.FlashSaleMapper;
import com.paladin.account.service.IFlashSaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 秒杀商品 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@Service
public class FlashSaleServiceImpl extends ServiceImpl<FlashSaleMapper, FlashSale> implements IFlashSaleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeFlashSaleServiceImpl.class);

    private FlashSaleMapper flashSaleMapper;

    public FlashSaleServiceImpl(FlashSaleMapper homeFlashSaleMapper) {
        this.flashSaleMapper = homeFlashSaleMapper;
    }

    @Override
    public List<HomeFlashSale> findHomeFlashSaleList() {
        flashSaleMapper.selectHomeFlashsaleList();
        return null;
    }
}
