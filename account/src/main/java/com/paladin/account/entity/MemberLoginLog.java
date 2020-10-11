package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员登录记录
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberLoginLog对象", description = "会员登录记录")
public class MemberLoginLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long memberId;

	private LocalDateTime createTime;

	private String ip;

	private String city;

	@ApiModelProperty(value = "登录类型：0->PC；1->android;2->ios;3->小程序")
	private Integer loginType;

	private String province;

}
