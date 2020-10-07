package com.paladin.account.entity;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 新鲜好物表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="HomeNewProduct对象", description="新鲜好物表")
public class HomeNewProduct extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long productId;

    private String productName;

    private Integer recommendStatus;

    private Integer sort;

}
