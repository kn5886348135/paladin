package com.paladin.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品信息
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("home_channel_square")
@ApiModel(value="ChannelSquare对象", description="商品信息")
public class ChannelSquare extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "频道标题")
    private String mainTitle;

    @ApiModelProperty(value = "频道广场副标题")
    private String subTitle;

    @ApiModelProperty(value = "产品图片url")
    private String productImage1;

    @ApiModelProperty(value = "产品图片url")
    private String productImage2;

    @ApiModelProperty(value = "频道详情url")
    private String detailUrl1;

    @ApiModelProperty(value = "频道详情url")
    private String detailUrl2;

    @ApiModelProperty(value = "频道详情url")
    private String detailUrl3;

    @ApiModelProperty(value = "是否大图，1大图，0小图")
    private Boolean isPrimary;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Boolean deleteStatus;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "创建者")
    private String createbBy;

    @ApiModelProperty(value = "最后更新者")
    private String lastUpdatedBy;

}
