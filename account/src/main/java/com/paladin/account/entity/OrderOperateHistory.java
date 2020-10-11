package com.paladin.account.entity;

import java.time.LocalDateTime;

import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单操作历史记录
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OrderOperateHistory对象", description = "订单操作历史记录")
public class OrderOperateHistory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "订单id")
	private Long orderId;

	@ApiModelProperty(value = "操作人：用户；系统；后台管理员")
	private String operateMan;

	@ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
	private Boolean orderStatus;

	@ApiModelProperty(value = "备注")
	private String note;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	@ApiModelProperty(value = "最后修改时间")
	private LocalDateTime gmtModified;

}
