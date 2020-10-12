package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 微信支付记录表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PayAli对象", description = "微信支付记录表")
public class PayAli extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "账户ID，保证全局唯一，防爬，趋势递增")
	private Long accountId;

	@ApiModelProperty(value = "账户名称")
	private String accountName;

	@ApiModelProperty(value = "昵称")
	private String nickname;

	@ApiModelProperty(value = "手机号码")
	private String phone;



	@ApiModelProperty(value = "支付宝分配给开发者的应用ID")
	private String appId;

	@ApiModelProperty(value = "接口名称")
	private String method;

	@ApiModelProperty(value = "仅支持JSON")
	private String format;

	@ApiModelProperty(value = "HTTP/HTTPS开头字符串")
	private String returnUrl;

	@ApiModelProperty(value = "请求使用的编码格式，如utf-8,gbk,gb2312等")
	private String charset;

	@ApiModelProperty(value = "商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2")
	private String signType;

	@ApiModelProperty(value = "商户请求参数的签名串，详见签名")
	private String sign;

	@ApiModelProperty(value = "支付宝交易号")
	private String tradeNo;

	@ApiModelProperty(value = "收款支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字")
	private String sellerId;

	@ApiModelProperty(value = "发送请求的时间，格式\"yyyy-MM-dd HH:mm:ss\"")
	private String timestamp;

	@ApiModelProperty(value = "调用的接口版本，固定为：1.0")
	private String version;

	@ApiModelProperty(value = "支付宝服务器主动通知商户服务器里指定的页面http/https路径。")
	private String notifyUrl;

	@ApiModelProperty(value = "详见应用授权概述")
	private String appAuthToken;

	@ApiModelProperty(value = "请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档")
	private String bizContent;

	@ApiModelProperty(value = "商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复")
	private String outTradeNo;

	@ApiModelProperty(value = "销售产品码，与支付宝签约的产品码名称。注：目前仅支持FAST_INSTANT_TRADE_PAY")
	private String productCode;

	@ApiModelProperty(value = "订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。")
	private BigDecimal totalAmount;

	@ApiModelProperty(value = "订单标题")
	private String subject;

	@ApiModelProperty(value = "订单描述")
	private String body;

	@ApiModelProperty(value = "绝对超时时间，格式为yyyy-MM-dd HH:mm:ss")
	private String timeExpire;

	@ApiModelProperty(value = "订单包含的商品列表信息，json格式，其它说明详见商品明细说明")
	private String goodsDetail;

	@ApiModelProperty(value = "公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在同步返回（包括跳转回商户网站）和异步通知时将该参数原样返回。本参数必须进行UrlEncode" +
			"之后才可以发送给支付宝。")
	private String passbackParams;

	@ApiModelProperty(value = "业务扩展参数")
	private String extendParams;

	@ApiModelProperty(value = "商品主类型 :0-虚拟类商品,1-实物类商品。注：虚拟类商品不支持使用花呗渠道")
	private String goodsType;

	@ApiModelProperty(value = "该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 " +
			"该参数数值不接受小数点， 如 1.5h，可转换为 90m")
	private String timeoutExpress;

	@ApiModelProperty(value = "优惠参数。注：仅与支付宝协商后可用")
	private String promoParams;

	@ApiModelProperty(value = "描述分账信息，json格式，详见分账参数说明")
	private String royaltyInfo;

	@ApiModelProperty(value = "间连受理商户信息体，当前只对特殊银行机构特定场景下使用此字段")
	private String subMerchant;

	@ApiModelProperty(value = "商户原始订单号，最大长度限制32位")
	private String merchantOrderNo;

	@ApiModelProperty(value = "可用渠道,用户只能在指定渠道范围内支付，多个渠道以逗号分割。注，与disable_pay_channels互斥。渠道列表：https://docs.open.alipay" +
			".com/common/wifww7")
	private String enablePayChannels;

	@ApiModelProperty(value = "商户门店编号")
	private String storeId;

	@ApiModelProperty(value = "禁用渠道,用户不可用指定渠道支付，多个渠道以逗号分割。注，与enable_pay_channels互斥。渠道列表：https://docs.open.alipay" +
			".com/common/wifww7")
	private String disablePayChannels;

	@ApiModelProperty(value = "PC扫码支付的方式，支持前置模式和跳转模式。前置模式是将二维码前置到商户的订单确认页的模式。需要商户在自己的页面中以 iframe " +
			"方式请求。支付宝页面。具体分为以下几种：0：订单码-简约前置模式，对应 iframe 宽度不能小于1：订单码-前置模式，对应iframe 宽度不能小于 " +
			"300px，高度不能小于600px；600px，高度不能小于300px；3：订单码-迷你前置模式，对应 iframe 宽度不能小于 " +
			"75px，高度不能小于75px；4：订单码-可定义宽度的嵌入式二维码，商户可根据需要设定二维码的大小。跳转模式下，用户的扫码界面是由支付宝生成的，不在商户的域名下。2：订单码-跳转模式")
	private String qrPayMode;

	@ApiModelProperty(value = "商户自定义二维码宽度。注：qr_pay_mode=4时该参数生效")
	private Integer qrcodeWidth;

	@ApiModelProperty(value = "描述结算信息，json格式，详见结算参数说明")
	private String settleInfo;

	@ApiModelProperty(value = "开票信息")
	private String invoiceInfo;

	@ApiModelProperty(value = "签约参数，支付后签约场景使用")
	private String agreementSignParams;

	@ApiModelProperty(value = "请求后页面的集成方式。取值范围：1. ALIAPP：支付宝钱包内2. PCWEB：PC端访问。默认值为PCWEB。")
	private String integrationType;

	@ApiModelProperty(value = "请求来源地址。如果使用ALIAPP的集成方式，用户中途取消支付会返回该地址。")
	private String requestFromUrl;

	@ApiModelProperty(value = "商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式")
	private String businessParams;

	@ApiModelProperty(value = "外部指定买家")
	private String extUserInfo;

	@ApiModelProperty(value = "网关返回码,详见文档")
	private String code;

	@ApiModelProperty(value = "网关返回码描述,详见文档")
	private String msg;

	@ApiModelProperty(value = "业务返回码，参见具体的API接口文档")
	private String subCode;

	@ApiModelProperty(value = "业务返回码描述，参见具体的API接口文档")
	private String subMsg;

}
