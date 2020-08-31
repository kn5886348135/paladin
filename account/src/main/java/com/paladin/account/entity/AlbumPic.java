package com.paladin.account.entity;
import com.paladin.account.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 画册图片表
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="AlbumPic对象", description="画册图片表")
public class AlbumPic extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long albumId;

    private String pic;

}
