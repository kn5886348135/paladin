package com.paladin.account.entity;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 后台用户角色和权限关系表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="RolePermissionRelation对象", description="后台用户角色和权限关系表")
public class RolePermissionRelation extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long permissionId;

}
