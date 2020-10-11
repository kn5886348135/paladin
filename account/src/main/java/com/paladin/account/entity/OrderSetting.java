package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单设置表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderSetting对象", description = "订单设置表")
public class OrderSetting extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "秒杀订单超时关闭时间(分)")
	private Integer flashOrderOvertime;

	@ApiModelProperty(value = "正常订单超时时间(分)")
	private Integer normalOrderOvertime;

	@ApiModelProperty(value = "发货后自动确认收货时间（天）")
	private Integer confirmOvertime;

	@ApiModelProperty(value = "自动完成交易时间，不能申请售后（天）")
	private Integer finishOvertime;

	@ApiModelProperty(value = "订单完成后自动好评时间（天）")
	private Integer commentOvertime;

}
