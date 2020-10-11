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
 * 商品信息
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Product对象", description = "商品信息")
public class Product extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "品牌id")
	private Long brandId;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "产品分类id")
	private Long productCategoryId;

	@ApiModelProperty(value = "商品分类名称")
	private String productCategoryName;

	@ApiModelProperty(value = "产品分类级别，1为最上层分类")
	private Integer productCategoryLevel;

	@ApiModelProperty(value = "运费模板id")
	private Long feightTemplateId;

	@ApiModelProperty(value = "产品属性分类id")
	private Long productAttributeCategoryId;

	@ApiModelProperty(value = "产品名称")
	private String productName;

	@ApiModelProperty(value = "产品图片链接")
	private String pic;

	@ApiModelProperty(value = "货号")
	private String productSn;

	@ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
	private Integer deleteStatus;

	@ApiModelProperty(value = "上架状态：0->下架；1->上架")
	private Integer publishStatus;

	@ApiModelProperty(value = "新品状态:0->不是新品；1->新品")
	private Integer newStatus;

	@ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐")
	private Integer recommandStatus;

	@ApiModelProperty(value = "审核状态：0->未审核；1->审核通过")
	private Integer verifyStatus;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "销量")
	private Integer sale;

	@ApiModelProperty(value = "价格")
	private BigDecimal price;

	@ApiModelProperty(value = "市场价")
	private BigDecimal originalPrice;

	@ApiModelProperty(value = "促销价格")
	private BigDecimal promotionPrice;

	@ApiModelProperty(value = "赠送的成长值")
	private Integer giftGrowth;

	@ApiModelProperty(value = "赠送的积分")
	private Integer giftPoint;

	@ApiModelProperty(value = "限制使用的积分数")
	private Integer usePointLimit;

	@ApiModelProperty(value = "副标题")
	private String subTitle;

	@ApiModelProperty(value = "商品描述")
	private String description;

	@ApiModelProperty(value = "库存")
	private Integer stock;

	@ApiModelProperty(value = "库存预警值")
	private Integer lowStock;

	@ApiModelProperty(value = "单位")
	private String unit;

	@ApiModelProperty(value = "商品重量，默认为克")
	private BigDecimal weight;

	@ApiModelProperty(value = "是否为预告商品：0->不是；1->是")
	private Integer previewStatus;

	@ApiModelProperty(value = "以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
	private String serviceIds;

	private String keywords;

	private String note;

	@ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割")
	private String albumPics;

	@ApiModelProperty(value = "详细标题")
	private String detailTitle;

	@ApiModelProperty(value = "详细描述")
	private String detailDesc;

	@ApiModelProperty(value = "产品详情网页内容")
	private String detailHtml;

	@ApiModelProperty(value = "移动端网页详情")
	private String detailMobileHtml;

	@ApiModelProperty(value = "促销开始时间")
	private LocalDateTime promotionStartTime;

	@ApiModelProperty(value = "促销结束时间")
	private LocalDateTime promotionEndTime;

	@ApiModelProperty(value = "活动限购数量")
	private Integer promotionPerLimit;

	@ApiModelProperty(value = "促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购")
	private Integer promotionType;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	@ApiModelProperty(value = "最后更新时间")
	private LocalDateTime gmtModified;

}
