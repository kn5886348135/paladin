package com.paladin.account.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 限时购表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "FlashPromotion对象", description = "限时购表")
public class FlashPromotion extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String title;

	@ApiModelProperty(value = "开始日期")
	private LocalDate startDate;

	@ApiModelProperty(value = "结束日期")
	private LocalDate endDate;

	@ApiModelProperty(value = "上下线状态")
	private Integer status;

	@ApiModelProperty(value = "秒杀时间段名称")
	private LocalDateTime createTime;

}
