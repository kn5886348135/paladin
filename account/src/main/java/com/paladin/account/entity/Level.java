package com.paladin.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 会员等级表
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("account_level")
@ApiModel(value = "Level对象", description = "会员等级表")
public class Level extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "会员等级名称")
	private String gradeName;

	private Integer growthPoint;

	@ApiModelProperty(value = "是否为默认等级：0->不是；1->是")
	private Integer defaultStatus;

	@ApiModelProperty(value = "免运费标准")
	private BigDecimal freeFreightPoint;

	@ApiModelProperty(value = "每次评价获取的成长值")
	private Integer commentGrowthPoint;

	@ApiModelProperty(value = "是否有免邮特权")
	private Integer priviledgeFreeFreight;

	@ApiModelProperty(value = "是否有签到特权")
	private Integer priviledgeSignIn;

	@ApiModelProperty(value = "是否有评论获奖励特权")
	private Integer priviledgeComment;

	@ApiModelProperty(value = "是否有专享活动特权")
	private Integer priviledgePromotion;

	@ApiModelProperty(value = "是否有会员价格特权")
	private Integer priviledgeMemberPrice;

	@ApiModelProperty(value = "是否有生日特权")
	private Integer priviledgeBirthday;

	@ApiModelProperty(value = "备注")
	private String note;

}
