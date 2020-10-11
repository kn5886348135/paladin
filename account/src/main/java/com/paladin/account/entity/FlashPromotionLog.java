package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 限时购通知记录
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "FlashPromotionLog对象", description = "限时购通知记录")
public class FlashPromotionLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer memberId;

	private Long productId;

	private String memberPhone;

	private String productName;

	@ApiModelProperty(value = "会员订阅时间")
	private LocalDateTime subscribeTime;

	private LocalDateTime sendTime;

}
