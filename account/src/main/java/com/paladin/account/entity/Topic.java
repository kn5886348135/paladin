package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 话题表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Topic对象", description = "话题表")
public class Topic extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long categoryId;

	private String name;

	private LocalDateTime createTime;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	@ApiModelProperty(value = "参与人数")
	private Integer attendCount;

	@ApiModelProperty(value = "关注人数")
	private Integer attentionCount;

	private Integer readCount;

	@ApiModelProperty(value = "奖品名称")
	private String awardName;

	@ApiModelProperty(value = "参与方式")
	private String attendType;

	@ApiModelProperty(value = "话题内容")
	private String content;

}
