package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品审核记录
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductVertifyRecord对象", description = "商品审核记录")
public class ProductVertifyRecord extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品id")
	private Long productId;

	@ApiModelProperty(value = "审核人")
	private String vertifyMan;

	@ApiModelProperty(value = "状态")
	private Boolean status;

	@ApiModelProperty(value = "反馈详情")
	private String detail;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	@ApiModelProperty(value = "最后修改时间")
	private LocalDateTime gmtModified;

}
