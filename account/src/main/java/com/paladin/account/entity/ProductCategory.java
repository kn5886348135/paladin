package com.paladin.account.entity;
import java.time.LocalDateTime;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 产品分类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ProductCategory对象", description="产品分类")
public class ProductCategory extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "上机分类的编号：1表示一级分类")
    private Long parentId;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "分类级别：1->1级；2->2级")
    private Integer level;

    @ApiModelProperty(value = "产品数量")
    private Integer productCount;

    @ApiModelProperty(value = "产品单位")
    private String productUnit;

    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime gmtModified;

}
