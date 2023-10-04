package com.paladin.account.entity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 秒杀商品
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="HomeCoupon对象", description="秒杀商品")
public class HomeCoupon extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "优惠券图片url")
    private String couponImage;

    @ApiModelProperty(value = "优惠券连接")
    private String detailUrl;

    @ApiModelProperty(value = "优惠券价格")
    private Integer couponPrice;

    @ApiModelProperty(value = "可用条件")
    private String condition;

//    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
//    private Boolean deleteStatus;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "最后更新人")
    private String lastUpdatedBy;

}
