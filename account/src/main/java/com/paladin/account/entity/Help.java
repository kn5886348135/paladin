package com.paladin.account.entity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
/**
 * <p>
 * 帮助表
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Help对象", description="帮助表")
public class Help extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long categoryId;

    private String icon;

    private String title;

    private Integer showStatus;

    private LocalDateTime createTime;

    private Integer readCount;

    private String content;

}
