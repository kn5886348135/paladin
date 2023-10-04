package com.paladin.account.service;

import com.paladin.account.entity.Banner;
import com.baomidou.mybatisplus.extension.service.IService;
import com.paladin.account.vo.BannerVO;

/**
 * <p>
 * 首页banner 服务类
 * </p>
 *
 * @author paladin
 * @since 2022-02-13
 */
public interface IBannerService extends IService<Banner> {
    BannerVO findBannerList();
    void testUpdateCount();
}
