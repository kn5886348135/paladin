package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Brand对象", description = "品牌表")
public class Brand extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "首字母")
	private String firstLetter;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
	private Boolean factoryStatus;

	private Boolean showStatus;

	@ApiModelProperty(value = "产品数量")
	private Integer productCount;

	@ApiModelProperty(value = "产品评论数量")
	private Integer productCommentCount;

	@ApiModelProperty(value = "品牌logo")
	private String logo;

	@ApiModelProperty(value = "专区大图")
	private String bigPic;

	@ApiModelProperty(value = "品牌故事")
	private String brandStory;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	@ApiModelProperty(value = "最后修改时间")
	private LocalDateTime gmtModified;

}
