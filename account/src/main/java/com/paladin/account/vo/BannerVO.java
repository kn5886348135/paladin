package com.paladin.account.vo;

import com.paladin.account.entity.Banner;
import lombok.Data;

import java.util.List;

@Data
public class BannerVO {
    private List<Banner> bannerList;
    private List<List<Banner>> recommendList;
}
