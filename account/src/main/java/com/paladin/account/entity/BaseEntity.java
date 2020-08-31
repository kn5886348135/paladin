package com.paladin.account.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/26 20:27
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7212782796791882630L;
    private long id;
    private short delete;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
