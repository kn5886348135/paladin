package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品评价回复表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CommentReplay对象", description = "产品评价回复表")
public class CommentReplay extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long commentId;

	private String memberNickName;

	private String memberIcon;

	private String content;

	private LocalDateTime createTime;

	@ApiModelProperty(value = "评论人员类型；0->会员；1->管理员")
	private Integer type;

}
