package com.paladin.account.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ProductOperateLog对象", description="")
public class ProductOperateLog extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "修改前价格")
    private BigDecimal priceOld;

    @ApiModelProperty(value = "修改后价格")
    private BigDecimal priceNew;

    @ApiModelProperty(value = "修改前售价")
    private BigDecimal salePriceOld;

    @ApiModelProperty(value = "修改后售价")
    private BigDecimal salePriceNew;

    @ApiModelProperty(value = "修改前赠送的积分")
    private Integer giftPointOld;

    @ApiModelProperty(value = "修改后赠送的积分")
    private Integer giftPointNew;

    @ApiModelProperty(value = "修改前积分使用上限")
    private Integer usePointLimitOld;

    @ApiModelProperty(value = "修改后积分使用上限")
    private Integer usePointLimitNew;

    @ApiModelProperty(value = "操作人")
    private String operateMan;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime gmtModified;

}
