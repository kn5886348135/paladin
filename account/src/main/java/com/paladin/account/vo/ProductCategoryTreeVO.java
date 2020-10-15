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
public class ProductCategoryTreeVO implements Serializable {

	private static final long serialVersionUID = -7280002012319611014L;

	@ApiModelProperty(value = "上机分类的编号：1表示一级分类")
	private Long parentNo;

	@ApiModelProperty(value = "分类编号")
	private String categoryNo;

	@ApiModelProperty(value = "分类名称")
	private String categoryName;

	@ApiModelProperty(value = "分类级别：1->1级；2->2级")
	private Integer tier;

	@ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
	private Integer navStatus;

	@ApiModelProperty(value = "显示状态：0->不显示；1->显示")
	private Integer showStatus;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "关键字")
	private String keywords;

	private List<ProductCategoryTreeVO> categoryVOList;
}
