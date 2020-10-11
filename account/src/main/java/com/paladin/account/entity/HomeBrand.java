package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 首页推荐品牌表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "HomeBrand对象", description = "首页推荐品牌表")
public class HomeBrand extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long brandId;

	private String brandName;

	private Integer recommendStatus;

	private Integer sort;

}
