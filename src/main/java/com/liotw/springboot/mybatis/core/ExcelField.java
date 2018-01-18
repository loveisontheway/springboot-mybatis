package com.liotw.springboot.mybatis.core;

import java.lang.annotation.*;

/**
 * 列属性信息
 * 支持Java对象数据类型：Boolean、String、Short、Integer、Long、Float、Double、Date
 * 支持Excel的Cell类型为：String
 *
 * @author jiangjialiang on 2017-09-12
 * @version 1.1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelField {

    /**
     * 列名称
     *
     * @return
     */
    String name() default "";

    /**
     * 列宽 (大于0时生效; 如果不指定列宽，将会自适应调整宽度；)
     *
     * @return
     */
    int width() default 0;

    /**
     * 时间格式化，日期类型时生效
     *
     * @return
     */
    String dateformat() default "yyyy-MM-dd HH:mm:ss";

}
