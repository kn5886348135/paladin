package com.paladin.account.mapper;

import com.paladin.account.entity.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 首页banner Mapper 接口
 * </p>
 *
 * @author paladin
 * @since 2022-02-13
 */
public interface BannerMapper extends BaseMapper<Banner> {

    List<Banner> selectBannerList();

    List<Banner> selectRecommendList();

    int testBatchUpdate(List<Banner> bannerList);
}
