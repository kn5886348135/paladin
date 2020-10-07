package com.paladin.account.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
/**
 * <p>
 * 微信支付退款记录表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PayWxRefund对象", description="微信支付退款记录表")
public class PayWxRefund extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户ID，保证全局唯一，防爬，趋势递增")
    private Long accountId;

    @ApiModelProperty(value = "账户名称")
    private String accountName;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "调用接口提交的公众账号ID")
    private String appid;

    @ApiModelProperty(value = "微信支付分配的商户号")
    private String mchId;

    @ApiModelProperty(value = "自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传\"WEB\\")
    private String deviceInfo;

    @ApiModelProperty(value = "随机字符串，长度要求在32位以内。推荐随机数生成算法")
    private String nonceStr;

    @ApiModelProperty(value = "通过签名算法计算得出的签名值，详见签名生成算法")
    private String sign;

    @ApiModelProperty(value = "签名类型，默认为MD5，支持HMAC-SHA256和MD5。")
    private String signType;

    @ApiModelProperty(value = "商品简单描述，该字段请按照规范传递，具体请见参数规定")
    private String body;

    @ApiModelProperty(value = "商品详细描述，对于使用单品优惠的商户，该字段必须按照规范上传，详见“单品优惠参数说明”")
    private String detail;

    @ApiModelProperty(value = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。")
    private String attach;

    @ApiModelProperty(value = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号")
    private String outTradeNo;

    @ApiModelProperty(value = "符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型")
    private String feeType;

    @ApiModelProperty(value = "订单总金额，单位为分，详见支付金额")
    private Integer totalFee;

    @ApiModelProperty(value = "支持IPV4和IPV6两种格式的IP地址。用户的客户端IP")
    private String spbillCreateIp;

    @ApiModelProperty(value = "订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则")
    private String timeStart;

    @ApiModelProperty(value = "订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取	新的prepay_id。其他详见时间规则	建议：最短失效时间间隔大于1分钟")
    private String timeExpire;

    @ApiModelProperty(value = "订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠")
    private String goodsTag;

    @ApiModelProperty(value = "异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。")
    private String notifyUrl;

    @ApiModelProperty(value = "JSAPI -JSAPI支付 NATIVE -Native支付 APP -APP支付 说明详见参数规定")
    private String tradeType;

    @ApiModelProperty(value = "trade_type=NATIVE时，此参数必传。此参数为二维码中包含的商品ID，商户自行定义。")
    private String productId;

    @ApiModelProperty(value = "上传此参数no_credit--可限制用户不能使用信用卡支付")
    private String limitPay;

    @ApiModelProperty(value = "trade_type=JSAPI时（即JSAPI支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。openid	如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用	【企业号userid转openid接口】进行转换")
    private String openid;

    @ApiModelProperty(value = "Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票	功能，传此字段才可生效")
    private String receipt;

    @ApiModelProperty(value = "该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段	为JSON对象数据，对象格式为{\"store_info\":{\"id\": \"门店ID\",\"name\": \"名称\",\"area_code\": \"编码\",\"address\":\"地址\" }} ，字段详细说明请点击行前的+展开")
    private String sceneInfo;

    @ApiModelProperty(value = "SUCCESS/FAIL")
    private String resultCode;

    @ApiModelProperty(value = "当result_code为FAIL时返回错误代码，详细参见下文错误列表")
    private String errCode;

    @ApiModelProperty(value = "当result_code为FAIL时返回错误描述，详细参见下文错误列表")
    private String errCodeDes;

    @ApiModelProperty(value = "微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时")
    private String prepayId;

    @ApiModelProperty(value = "trade_type=NATIVE时有返回，此url用于生成支付二维码，然后提供给用户进行扫码支付。	注意：code_url的值并非固定，使用时按照URL格式转成二维码即可")
    private String codeUrl;

    @ApiModelProperty(value = "当return_code为FAIL时返回信息为错误原因 ，例如签名失败,参数格式校验错误")
    private String returnMsg;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime gmtModified;

}
