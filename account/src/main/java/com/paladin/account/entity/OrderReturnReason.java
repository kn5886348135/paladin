package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 退货原因表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderReturnReason对象", description = "退货原因表")
public class OrderReturnReason extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "退货类型")
	private String name;

	private Integer sort;

	@ApiModelProperty(value = "状态：0->不启用；1->启用")
	private Integer status;

	@ApiModelProperty(value = "添加时间")
	private LocalDateTime createTime;

}
