package com.paladin.account.entity;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 优惠券和产品分类关系表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="CouponProductCategoryRelation对象", description="优惠券和产品分类关系表")
public class CouponProductCategoryRelation extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long couponId;

    private Long productCategoryId;

    @ApiModelProperty(value = "产品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "父分类名称")
    private String parentCategoryName;

}
