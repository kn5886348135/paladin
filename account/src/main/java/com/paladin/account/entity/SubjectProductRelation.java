package com.paladin.account.entity;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 专题商品关系表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SubjectProductRelation对象", description = "专题商品关系表")
public class SubjectProductRelation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long subjectId;

	private Long productId;

}
