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
@ApiModel(value = "ProductCategory对象", description = "产品分类")
public class ProductCategoryTitleVO implements Serializable {

	private static final long serialVersionUID = 7241412069785801710L;

	@ApiModelProperty(value = "父分类的编号：0表示一级分类")
	private Long id;

	@ApiModelProperty(value = "父分类的编号：0表示一级分类")
	private Long parentNo;

	@ApiModelProperty(value = "分类编号")
	private String categoryNo;

	@ApiModelProperty(value = "分类名称")
	private String categoryName;

	@ApiModelProperty(value = "分类链接")
	private String linkUrl;

	@ApiModelProperty(value = "频道编号")
	private Integer channelNum;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	private List<ProductCategoryVO> contentList;
}
