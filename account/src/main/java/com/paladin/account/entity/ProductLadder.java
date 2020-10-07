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
 * 产品阶梯价格表(只针对同商品)
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ProductLadder对象", description="产品阶梯价格表(只针对同商品)")
public class ProductLadder extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "满足的商品数量")
    private Integer count;

    @ApiModelProperty(value = "折扣")
    private BigDecimal discount;

    @ApiModelProperty(value = "折后价格")
    private BigDecimal price;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime gmtModified;

}
