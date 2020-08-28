package com.paladin.account.aop;

import java.lang.annotation.*;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/27 23:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationLog {
    String remark() default "";
}
