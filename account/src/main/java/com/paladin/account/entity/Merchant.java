package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商家信息表
 * </p>
 *
 * @author paladin
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Merchant对象", description = "商家信息表")
public class Merchant extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商家编号")
	private Long merchantNo;

	@ApiModelProperty(value = "商家名称")
	private String merchantName;

	@ApiModelProperty(value = "商户类型，1个人商户，2企业商户")
	private String merchantType;

	@ApiModelProperty(value = "商户证件号码，merchant_type为1是身份证号码，2是企业社会统一信用代码")
	private String merchantId;

}
