package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户和标签关系表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberTagRelation对象", description = "用户和标签关系表")
public class MemberTagRelation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long memberId;

	private Long tagId;

}
