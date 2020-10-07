package com.paladin.account.entity;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 优选专区和产品关系表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PrefrenceAreaProductRelation对象", description="优选专区和产品关系表")
public class PrefrenceAreaProductRelation extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long prefrenceAreaId;

    private Long productId;

}
