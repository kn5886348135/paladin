package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 专题表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Subject对象", description = "专题表")
public class Subject extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long categoryId;

	private String title;

	@ApiModelProperty(value = "专题主图")
	private String pic;

	@ApiModelProperty(value = "关联产品数量")
	private Integer productCount;

	private Integer recommendStatus;

	private LocalDateTime createTime;

	private Integer collectCount;

	private Integer readCount;

	private Integer commentCount;

	@ApiModelProperty(value = "画册图片用逗号分割")
	private String albumPics;

	private String description;

	@ApiModelProperty(value = "显示状态：0->不显示；1->显示")
	private Integer showStatus;

	private String content;

	@ApiModelProperty(value = "转发数")
	private Integer forwardCount;

	@ApiModelProperty(value = "专题分类名称")
	private String categoryName;

}
