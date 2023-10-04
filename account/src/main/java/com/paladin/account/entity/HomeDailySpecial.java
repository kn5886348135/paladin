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
@ApiModel(value="HomeDailySpecial对象", description="商品信息")
public class HomeDailySpecial extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题没有父节点，parent_id为0")
    private Long parentId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品图片url")
    private String productImage;

    @ApiModelProperty(value = "秒杀详情url")
    private String detailUrl;

    @ApiModelProperty(value = "产品价格")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "已抢数量")
    private Integer saledCount;

    @ApiModelProperty(value = "是否大图，1大图，0小图")
    private Boolean isPrimariy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "最后更新人")
    private String lastUpdatedBy;

}
