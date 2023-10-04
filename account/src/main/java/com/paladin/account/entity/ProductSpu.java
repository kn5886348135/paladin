package com.paladin.account.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品信息
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ProductSpu对象", description="商品信息")
public class ProductSpu extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "sku")
    private Long productSku;

    @ApiModelProperty(value = "spu")
    private Long productSpu;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品详情页链接")
    private String detailUrl;

    @ApiModelProperty(value = "产品图片链接")
    private String imageUrl;

    @ApiModelProperty(value = "店铺编号")
    private Integer shopNo;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "店铺链接")
    private String shopUrl;

    @ApiModelProperty(value = "品牌编码")
    private Integer brandNo;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "评论数量")
    private String commentCounts;

    @ApiModelProperty(value = "产品分类编号")
    private Integer categoryNo;

    @ApiModelProperty(value = "商品分类名称")
    private String categoryName;

    @ApiModelProperty(value = "参数标签，|分割")
    private String paramTag;

    @ApiModelProperty(value = "促销标签，|分割")
    private String promotionTag;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal plusPrice;

    @ApiModelProperty(value = "是否自营，1自营，0非自营")
    private Boolean proprietary;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Boolean deleteStatus;

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
