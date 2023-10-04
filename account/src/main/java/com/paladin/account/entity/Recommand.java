package com.paladin.account.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("home_recommand")
@ApiModel(value="Recommand对象", description="商品信息")
public class Recommand extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父id为0的是标题")
    private Long parentId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "副标题")
    private String subTitle;

    @ApiModelProperty(value = "产品图片url")
    private String productImage;

    @ApiModelProperty(value = "秒杀详情url")
    private String detailUrl;

    @ApiModelProperty(value = "产品价格")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "会员价")
    private BigDecimal memberPrice;

    @ApiModelProperty(value = "1自营，0非自营")
    private Boolean proprietary;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Boolean deleteStatus;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "创建者")
    private String createdBy;

    @ApiModelProperty(value = "最后更新者")
    private String lastUpdatedBy;

}
