package com.paladin.account.entity;

import java.math.BigDecimal;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户标签表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberTag对象", description = "用户标签表")
public class MemberTag extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	@ApiModelProperty(value = "自动打标签完成订单数量")
	private Integer finishOrderCount;

	@ApiModelProperty(value = "自动打标签完成订单金额")
	private BigDecimal finishOrderAmount;

}
