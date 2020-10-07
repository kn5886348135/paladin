package com.paladin.account.entity;
import java.time.LocalDateTime;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysPerm对象", description="")
public class SysPerm extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限名称")
    private String permName;

    @ApiModelProperty(value = "权限描述")
    private String permDesc;

    @ApiModelProperty(value = "权限值")
    private String permValue;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否禁用")
    private Integer isDisable;

}
