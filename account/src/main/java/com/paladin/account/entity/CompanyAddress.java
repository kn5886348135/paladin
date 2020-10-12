package com.paladin.account.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 公司收发货地址表
 * </p>
 *
 * @author paladin
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="CompanyAddress对象", description="公司收发货地址表")
public class CompanyAddress extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地址名称")
    private String addressName;

    @ApiModelProperty(value = "默认发货地址：0->否；1->是")
    private Boolean sendStatus;

    @ApiModelProperty(value = "是否默认收货地址：0->否；1->是")
    private Boolean receiveStatus;

    @ApiModelProperty(value = "收发货人姓名")
    private String receiverName;

    @ApiModelProperty(value = "收货人电话")
    private String receiverPhone;

    @ApiModelProperty(value = "省/直辖市")
    private String province;

    @ApiModelProperty(value = "市/县")
    private String city;

    @ApiModelProperty(value = "区")
    private String region;

    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

}
