package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员任务表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberTask对象", description = "会员任务表")
public class MemberTask extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	@ApiModelProperty(value = "赠送成长值")
	private Integer growth;

	@ApiModelProperty(value = "赠送积分")
	private Integer intergration;

	@ApiModelProperty(value = "任务类型：0->新手任务；1->日常任务")
	private Integer type;

}
