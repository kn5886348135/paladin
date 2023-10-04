package com.paladin.account.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/26 20:27
 */
@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -7212782796791882630L;

	private Long id;

	@ApiModelProperty(value = "删除状态，0->删除，1->未删除")
	// Boolean还是Byte？
	private Boolean deleteStatus;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;

	@ApiModelProperty(value = "最后修改时间")
	private LocalDateTime gmtModified;
}
