package com.paladin.account.entity;

import java.math.BigDecimal;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sku的库存
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SkuStock对象", description = "sku的库存")
public class SkuStock extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long productId;

	@ApiModelProperty(value = "sku编码")
	private String skuCode;

	private BigDecimal price;

	@ApiModelProperty(value = "库存")
	private Integer stock;

	@ApiModelProperty(value = "预警库存")
	private Integer lowStock;

	@ApiModelProperty(value = "销售属性1")
	private String sp1;

	private String sp2;

	private String sp3;

	@ApiModelProperty(value = "展示图片")
	private String pic;

	@ApiModelProperty(value = "销量")
	private Integer sale;

	@ApiModelProperty(value = "单品促销价格")
	private BigDecimal promotionPrice;

	@ApiModelProperty(value = "锁定库存")
	private Integer lockStock;

}
