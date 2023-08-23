package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author awl
 * @date 2023/8/23 22:33
 * 自定义注解, 标识某个方法需要进行功能字段自动填充处理
 */
@Target(ElementType.METHOD)//指定当前注解加在什么位置, 此处标识只能加在方法上面
@Retention(RetentionPolicy.RUNTIME)//用来表示注解的声明周期
public @interface AutoFill {

    //数据库操作类型: update insert
    OperationType value();


}
