package com.paladin.account.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
/**
 * <p>
 * 商品会员价格表
 * </p>
 *
 * @author paladin
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="MemberPrice对象", description="商品会员价格表")
public class MemberPrice extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long productId;

    private Long memberLevelId;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;

    private String memberLevelName;

}
