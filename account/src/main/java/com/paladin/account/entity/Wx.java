package com.paladin.account.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 会员表
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("account_wx")
@ApiModel(value="Wx对象", description="会员表")
public class Wx extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户ID，保证全局唯一，防爬，趋势递增")
    private Long accountId;

    @ApiModelProperty(value = "账户名称")
    private String openid;

    @ApiModelProperty(value = "密码")
    private String avatar;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String headimgurl;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime gmtModified;

}
