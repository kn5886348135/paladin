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
@ApiModel(value="HomeFlashSale对象", description="秒杀商品")
public class HomeFlashSale extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品图片url")
    private String productImage;

    @ApiModelProperty(value = "秒杀详情url")
    private String detailUrl;

    @ApiModelProperty(value = "产品价格")
    private String productPrice;

    @ApiModelProperty(value = "1秒杀，2品类秒杀")
    private Integer flashSaleType;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime gmtModified;

}
