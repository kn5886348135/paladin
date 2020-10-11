package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 人气推荐商品表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "HomeRecommendProduct对象", description = "人气推荐商品表")
public class HomeRecommendProduct extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long productId;

	private String productName;

	private Integer recommendStatus;

	private Integer sort;

}
