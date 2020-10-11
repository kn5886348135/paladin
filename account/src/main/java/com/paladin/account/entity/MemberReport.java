package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户举报表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberReport对象", description = "用户举报表")
public class MemberReport extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "举报类型：0->商品评价；1->话题内容；2->用户评论")
	private Integer reportType;

	@ApiModelProperty(value = "举报人")
	private String reportMemberName;

	private LocalDateTime createTime;

	private String reportObject;

	@ApiModelProperty(value = "举报状态：0->未处理；1->已处理")
	private Integer reportStatus;

	@ApiModelProperty(value = "处理结果：0->无效；1->有效；2->恶意")
	private Integer handleStatus;

	private String note;

}
