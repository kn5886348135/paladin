package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRole对象", description = "角色表")
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色名称，用于显示")
	private String roleName;

	@ApiModelProperty(value = "角色描述")
	private String roleDesc;

	@ApiModelProperty(value = "角色值，用于权限判断")
	private String roleValue;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	@ApiModelProperty(value = "是否禁用")
	private Integer isDisable;

}
