package com.paladin.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

	@Size(min = 6, max = 16, message = "用户名只能是6-16个字符")
	@Pattern(regexp = "^[a-zA-Z0-9_\u4e00-\u9fa5]{6,16}$", message = "用户名只能是中文、英文大小写和下划线")
	@ApiModelProperty(value = "账户名称")
	private String accountName;

	@Size(min = 6, max = 16, message = "密码只能是6-16个字符")
	@ApiModelProperty(value = "密码")
	private String passwd;

	@ApiModelProperty(value = "昵称")
	private String nickname;

	@Pattern(regexp = "[1][3,4,5,6,7,8,9][0-9]{9}", message = "手机号码格式不正确")
	@ApiModelProperty(value = "手机号码")
	private String phone;

	@Pattern(regexp = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$", message = "邮箱格式不正确")
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
	private Boolean state;

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

	// 验证码
	@TableField(exist = false)
	private String code;
}
