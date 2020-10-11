package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "RolePerm对象", description = "角色权限表")
public class RolePerm extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "权限id")
	private String permId;

	@ApiModelProperty(value = "角色id")
	private String roleId;

}
