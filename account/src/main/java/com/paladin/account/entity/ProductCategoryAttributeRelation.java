package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductCategoryAttributeRelation对象", description = "产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）")
public class ProductCategoryAttributeRelation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long productCategoryId;

	private Long productAttributeId;

}
