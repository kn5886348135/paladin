package com.paladin.account.service.impl;

import com.paladin.account.entity.Banner;
import com.paladin.account.mapper.BannerMapper;
import com.paladin.account.service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paladin.account.vo.BannerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 首页banner 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2022-02-13
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerServiceImpl.class);

    private BannerMapper bannerMapper;

    public BannerServiceImpl(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    @Override
    public BannerVO findBannerList() {
        List<Banner> bannerList = bannerMapper.selectBannerList();
        List<Banner> recommendList = bannerMapper.selectRecommendList();
        recommendList.stream().collect(Collectors.groupingBy(Banner::getBannerGroup));
        BannerVO bannerVO = new BannerVO();
        bannerVO.setBannerList(bannerList);
        bannerVO.setRecommendList(recommendList.stream().collect(Collectors.groupingBy(Banner::getBannerGroup)).entrySet().stream().map(item -> item.getValue()).collect(Collectors.toList()));
        return bannerVO;
    }

    @Override
    public void testUpdateCount() {
        List<Banner> bannerlist = bannerMapper.selectBannerList();
        for (Banner banner : bannerlist) {
            banner.setGmtCreate(LocalDateTime.now());
        }
        int count = bannerMapper.testBatchUpdate(bannerlist);
        LOGGER.info("batch update count {}", count);
    }

}
