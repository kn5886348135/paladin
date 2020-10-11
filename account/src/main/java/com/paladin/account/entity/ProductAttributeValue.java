package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 存储产品参数信息的表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductAttributeValue对象", description = "存储产品参数信息的表")
public class ProductAttributeValue extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "产品id")
	private Long productId;

	@ApiModelProperty(value = "产品属性id")
	private Long productAttributeId;

	@ApiModelProperty(value = "手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开")
	private String value;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	@ApiModelProperty(value = "最后更新时间")
	private LocalDateTime gmtModified;

}
