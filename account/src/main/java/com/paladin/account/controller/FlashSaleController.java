package com.paladin.account.controller;

import com.paladin.account.entity.HomeFlashSale;
import com.paladin.account.service.IFlashSaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 秒杀商品 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@RestController
@RequestMapping("/account/flash-sale")
public class FlashSaleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeFlashSaleController.class);

    private IFlashSaleService flashSaleService;

    public FlashSaleController(IFlashSaleService flashSaleService) {
        this.flashSaleService = flashSaleService;
    }

    public List<HomeFlashSale> queryHomeFlashSaleList(){
        return flashSaleService.findHomeFlashSaleList();
    }
}
