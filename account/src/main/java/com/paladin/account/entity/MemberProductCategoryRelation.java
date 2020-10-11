package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员与产品分类关系表（用户喜欢的分类）
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MemberProductCategoryRelation对象", description = "会员与产品分类关系表（用户喜欢的分类）")
public class MemberProductCategoryRelation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long memberId;

	private Long productCategoryId;

}
