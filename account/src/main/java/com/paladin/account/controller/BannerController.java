package com.paladin.account.controller;

import com.paladin.account.service.IBannerService;
import com.paladin.account.vo.BannerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页banner 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2022-02-13
 */
@RestController
@RequestMapping("/banner")
public class BannerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerController.class);

    private IBannerService iBannerService;

    public BannerController(IBannerService iBannerService) {
        this.iBannerService = iBannerService;
    }

    @GetMapping
    @Retryable
    public BannerVO getBannerList() {
        return iBannerService.findBannerList();
    }

    @GetMapping("/test")
    public String test() {
        iBannerService.testUpdateCount();
        return "udpate success";
    }
}
