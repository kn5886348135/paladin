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
 * 秒杀商品
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("home_shop")
@ApiModel(value="Shop对象", description="秒杀商品")
public class Shop extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品名称")
    private String shopName;

    @ApiModelProperty(value = "产品图片url")
    private String shopImage;

    @ApiModelProperty(value = "秒杀详情url")
    private String detailUrl;

    @ApiModelProperty(value = "1自营，0非自营")
    private Boolean proprietary;

    @ApiModelProperty(value = "店铺标签")
    private String shopTag;

    @ApiModelProperty(value = "关注数量，单位万人")
    private String followedCount;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Boolean deleteStatus;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "最后更新人")
    private String lastUpdatedBy;

}
