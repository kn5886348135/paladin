package com.paladin.account.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Member对象", description = "会员表")
public class Member extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long memberLevelId;

	@ApiModelProperty(value = "用户名")
	private String username;

	@ApiModelProperty(value = "密码")
	private String passwd;

	@ApiModelProperty(value = "昵称")
	private String nickname;

	@ApiModelProperty(value = "手机号码")
	private String phone;

	@ApiModelProperty(value = "帐号启用状态:0->禁用；1->启用")
	private Integer status;

	@ApiModelProperty(value = "注册时间")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "头像")
	private String icon;

	@ApiModelProperty(value = "性别：0->未知；1->男；2->女")
	private Integer gender;

	@ApiModelProperty(value = "生日")
	private LocalDate birthday;

	@ApiModelProperty(value = "所做城市")
	private String city;

	@ApiModelProperty(value = "职业")
	private String job;

	@ApiModelProperty(value = "个性签名")
	private String personalizedSignature;

	@ApiModelProperty(value = "用户来源")
	private Integer sourceType;

	@ApiModelProperty(value = "积分")
	private Integer integration;

	@ApiModelProperty(value = "成长值")
	private Integer growth;

	@ApiModelProperty(value = "剩余抽奖次数")
	private Integer luckeyCount;

	@ApiModelProperty(value = "历史积分数量")
	private Integer historyIntegration;

}
