package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

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

}
