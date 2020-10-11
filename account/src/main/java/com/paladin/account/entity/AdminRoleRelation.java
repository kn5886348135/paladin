package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台用户和角色关系表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AdminRoleRelation对象", description = "后台用户和角色关系表")
public class AdminRoleRelation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long adminId;

	private Long roleId;

}
