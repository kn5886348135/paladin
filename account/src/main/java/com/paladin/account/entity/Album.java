package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 相册表
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Album对象", description = "相册表")
public class Album extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "相册名称")
	private String albumName;

	private String coverPic;

	@ApiModelProperty(value = "图片数量")
	private Integer picCount;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "描述")
	private String description;

}
