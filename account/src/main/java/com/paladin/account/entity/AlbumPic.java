package com.paladin.account.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.CodePointLength;
import org.hibernate.validator.constraints.Normalized;

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
@ApiModel(value = "AlbumPic对象", description = "画册图片表")
public class AlbumPic extends BaseEntity {

	private static final long serialVersionUID = 5404140170241264199L;

	private Long albumId;

	@Normalized
	@CodePointLength
	private String pic;

}
