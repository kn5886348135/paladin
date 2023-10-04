package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 首页banner
 * </p>
 *
 * @author paladin
 * @since 2022-02-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Banner对象", description="首页banner")
public class Banner extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "banner连接")
    private String linkUrl;

    @ApiModelProperty(value = "图片地址")
    private String srcUrl;

    @ApiModelProperty(value = "banner类型，1banner图，2推荐")
    private Integer bannerType;

    @ApiModelProperty(value = "banner分组")
    private Integer bannerGroup;
}
