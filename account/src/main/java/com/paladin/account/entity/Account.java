package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Account对象", description = "会员表")
public class Account extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "账户ID，保证全局唯一")
	private String accountId;

	@ApiModelProperty(value = "账户名称")
	private String accountName;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "昵称")
	private String nickname;

	@ApiModelProperty(value = "手机号码")
	private String phone;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "头像连接URL")
	private String avatar;

	@ApiModelProperty(value = "会员等级id")
	private Integer levelId;

	@ApiModelProperty(value = "用户余额")
	private BigDecimal cash;

	@ApiModelProperty(value = "积分余额")
	private Integer integral;

	@ApiModelProperty(value = "帐号启用状态:0->禁用；1->启用")
	private Boolean status;

	@ApiModelProperty(value = "性别：0->未知；1->男；2->女")
	private Boolean gender;

	@ApiModelProperty(value = "生日")
	private LocalDate birthday;

	@ApiModelProperty(value = "所在城市")
	private String city;

	@ApiModelProperty(value = "职业")
	private String job;

	@ApiModelProperty(value = "个性签名")
	private String personalizedSignature;

	@ApiModelProperty(value = "用户来源")
	private Boolean sourceType;

	@ApiModelProperty(value = "备注")
	private String description;

}
