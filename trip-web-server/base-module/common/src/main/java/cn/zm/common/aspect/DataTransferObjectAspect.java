package cn.zm.common.aspect;

import cn.zm.common.annotation.SetNull;
import cn.zm.common.base.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

/**
 * @author Mr_W
 * @date 2021/2/18 9:22
 * @description dto 参数切面
 */
@Aspect
@Slf4j
@Component
public class DataTransferObjectAspect {
    @Pointcut("execution(public * com.*.*.*.web.*.*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object proceed(ProceedingJoinPoint p) throws Throwable {
        Instant now = Instant.now();
        MethodSignature signature = (MethodSignature) p.getSignature();
        Method method = signature.getMethod();
        Annotation[][] methodAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < methodAnnotations.length; i++) {
            for (Annotation annotation : methodAnnotations[i]) {
                if (annotation instanceof Validated) {
                    // 如果有分组
                    if (((Validated) annotation).value().length != 0) {
                        p.getArgs()[i] = buildParams(p.getArgs()[i], ((Validated) annotation).value()[0]);
                    }
                }
            }
        }
        log.debug("入参构建完毕, 用时: [{}] ms", Duration.between(now, Instant.now()).toMillis());
        return p.proceed();
    }

    /**
     * 构建入参
     * @param obj 原始入参
     * @return 构建后的入参
     */
    private Object buildParams(Object obj, Class<?> type) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof SetNull) {
                    try {
                        Method groupMethod = annotation.annotationType().getDeclaredMethod("group");
                        Class<?> group = (Class<?>) groupMethod.invoke(annotation);
                        if (type.isAssignableFrom(group)) {
                            field.setAccessible(true);
                            field.set(obj, null);
                            field.setAccessible(false);
                        }
                    } catch (NoSuchMethodException e) {
                        log.error("没有 groups 方法", e);
                        throw ServiceException.serviceException("服务器异常", e).build();
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        log.error("groups 方法执行失败", e);
                        throw ServiceException.serviceException("服务器异常", e).build();
                    }
                }
            }
        }
        return obj;
    }

//    @Around("pointcut()")
//    public Object proceed(ProceedingJoinPoint p) throws Throwable {
//        Instant now = Instant.now();
//        MethodSignature signature = (MethodSignature) p.getSignature();
//        Method method = signature.getMethod();
//        Annotation[][] methodAnnotations = method.getParameterAnnotations();
//        for (int i = 0; i < methodAnnotations.length; i++) {
//            for (Annotation annotation : methodAnnotations[i]) {
//                if (annotation instanceof Validated) {
//                    // 如果有分组
//                    if (((Validated) annotation).value().length != 0) {
//                        p.getArgs()[i] = buildParams(p.getArgs()[i], ((Validated) annotation).value()[0]);
//                    }
//                }
//            }
//        }
//        LOGGER.debug("入参构建完毕, 用时: [{}] ms", Duration.between(now, Instant.now()).toMillis());
//        return proceed(p);
//    }
//
//    /**
//     * 构建入参
//     * @param obj 原始入参
//     * @return 构建后的入参
//     */
//    private Object buildParams(Object obj, Class<?> type) {
//        for (Field field : obj.getClass().getDeclaredFields()) {
//            for (Annotation annotation : field.getAnnotations()) {
//                if (annotation.annotationType().getName().contains("javax.validation.constraints")) {
//                    try {
//                        Method groups = annotation.annotationType().getDeclaredMethod("groups");
//                        Class<?> group = ((Class<?>[]) groups.invoke(annotation))[0];
//                        if (!type.isAssignableFrom(group)) {
//                            field.setAccessible(true);
//                            field.set(obj, null);
//                            field.setAccessible(false);
//                        }
//                    } catch (NoSuchMethodException e) {
//                        LOGGER.error("没有 groups 方法", e);
//                        throw new ServiceException("服务器异常");
//                    } catch (IllegalAccessException | InvocationTargetException e) {
//                        LOGGER.error("groups 方法执行失败", e);
//                        throw new ServiceException("服务器异常");
//                    }
//                }
//            }
//        }
//        return obj;
//    }

}
