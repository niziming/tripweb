package cn.zm.common.base;


import cn.hutool.core.util.StrUtil;
import cn.zm.common.enums.ResEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author Mr_W
 * @date 2021/2/16 14:14
 * @description: 通用异常
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 8935805243057842722L;

    private Integer code;

    private String alertMessage;

    public ServiceException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause) {
        this(ResEnum.BUSINESS_FAIL.getCode(), message, cause);
    }

    public ServiceException(String message) {
        this(ResEnum.BUSINESS_FAIL.getCode(), message);
    }

    public ServiceException(String alertMessage, String message, Throwable cause) {
        this(ResEnum.BUSINESS_FAIL.getCode(), message, cause);
        this.alertMessage = alertMessage;
    }

    public ServiceException(int code, String alertMessage, String message, Throwable cause) {
        this(code, message, cause);
        this.alertMessage = alertMessage;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    public Integer getCode() {
        return code;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    /**
     * 获取业务异常构造器, code 默认 500
     *
     * @param message 异常信息
     * @param params  占位符参数
     * @return 业务异常构造器
     */
    public static ServiceExceptionBuilder serviceException(String message, Object... params) {
        if (StringUtils.isBlank(message)) {
            throw new RuntimeException("message of service exception can not be null");
        }
        return new ServiceExceptionBuilder(StrUtil.format(message, getParams(params)), getThrowable(params));
    }

    /**
     * 获取业务异常构造器
     *
     * @param serviceExceptionEnum 业务异常枚举
     * @param cause                原始异常
     * @return 业务异常构造器
     */
    public static ServiceExceptionBuilder serviceException(ResEnum serviceExceptionEnum, Throwable cause) {
        if (Objects.isNull(serviceExceptionEnum)) {
            throw new RuntimeException("enum of service exception can not be null");
        }
        return new ServiceExceptionBuilder(serviceExceptionEnum, cause);
    }


    /**
     * 获取除异常外的参数
     *
     * @param params 参数
     * @return 除异常外的参数
     */
    private static Object[] getParams(Object... params) {
        if (params.length != 0 && params[params.length - 1] instanceof Throwable) {
            Object[] paramsCopy = new Object[params.length - 1];
            System.arraycopy(params, 0, paramsCopy, 0, params.length - 1);
            return paramsCopy;
        }
        return params;
    }

    /**
     * 获取异常
     *
     * @param params 参数
     * @return 异常
     */
    private static Throwable getThrowable(Object... params) {
        if (params.length != 0 && params[params.length - 1] instanceof Throwable) {
            return (Throwable) params[params.length - 1];
        }
        return null;
    }
}
