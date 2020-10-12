package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品属性分类表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductAttributeCategory对象", description = "产品属性分类表")
public class ProductAttributeCategory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "产品属性分类名称")
	private String attributeCategoryName;

	@ApiModelProperty(value = "属性数量")
	private Integer attributeCount;

	@ApiModelProperty(value = "参数数量")
	private Integer paramCount;

}
