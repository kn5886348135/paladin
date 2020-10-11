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
 * 产品满减表(只针对同商品)
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductFullReduction对象", description = "产品满减表(只针对同商品)")
public class ProductFullReduction extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long productId;

	private BigDecimal fullPrice;

	private BigDecimal reducePrice;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	@ApiModelProperty(value = "最后修改时间")
	private LocalDateTime gmtModified;

}
