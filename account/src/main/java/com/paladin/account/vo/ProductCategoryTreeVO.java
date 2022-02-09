package com.paladin.account.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 产品分类前端展示实体类
 * @author: paladin
 * @date: 2020/10/15 21:08
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "ProductCategory对象", description = "产品分类树")
public class ProductCategoryTreeVO implements Serializable {

	private static final long serialVersionUID = -7280002012319611014L;

	@ApiModelProperty(value = "频道编号")
	private Short channelNum;

	@ApiModelProperty(value = "分类列表")
	private List<ProductCategoryVO> productCategoryList;

	@ApiModelProperty(value = "聚合后的频道列表")
	private List<ProductCategoryVO> channelList;

	@ApiModelProperty(value = "聚合后的标题列表")
	private List<ProductCategoryVO> titleList;

	@ApiModelProperty(value = "品牌列表")
	private List<ProductCategoryVO> brandList;

	@ApiModelProperty(value = "促销列表")
	private List<ProductCategoryVO> promotionList;



}
