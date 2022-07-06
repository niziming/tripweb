package cn.zm.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Mr_W
 * @date 2021/2/18 12:37
 * @description: 当入参验证分组和该分组一致时设置为 null
 */
@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface SetNull {

    Class<?> group();

}
