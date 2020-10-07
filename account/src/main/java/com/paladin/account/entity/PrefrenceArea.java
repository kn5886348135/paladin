package com.paladin.account.entity;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 优选专区
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PrefrenceArea对象", description="优选专区")
public class PrefrenceArea extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private String name;

    private String subTitle;

    @ApiModelProperty(value = "展示图片")
    private byte[] pic;

    private Integer sort;

    private Integer showStatus;

}
