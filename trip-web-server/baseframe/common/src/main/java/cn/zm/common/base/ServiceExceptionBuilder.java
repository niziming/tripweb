package cn.zm.common.base;


import cn.zm.common.enums.ResEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author Mr_W
 * @date 2021/2/19 16:34
 * @description 业务异常构造器
 */
public class ServiceExceptionBuilder {

    /**
     * 异常信息日志记录
     */
    private String message;

    /**
     * 客户端警告
     */
    private String alertMessage;

    /**
     * 异常
     */
    private Throwable cause;

    /**
     * 错误码
     */
    private Integer code;

    private int buildMode = -1;

    /**
     * 构建异常信息, code 默认 500
     *
     * @param message 异常信息
     * @param cause   原始异常
     */
    public ServiceExceptionBuilder(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    /**
     * 构建异常信息
     *
     * @param serviceExceptionEnum 业务异常枚举
     * @param cause                原始异常
     */
    public ServiceExceptionBuilder(ResEnum serviceExceptionEnum, Throwable cause) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMsg();
        this.alertMessage = serviceExceptionEnum.getMsg();
        this.cause = cause;
    }

    /**
     * 设置客户端警告信息
     *
     * @param alertMessage 客户端警告信息
     * @return this
     */
    public ServiceExceptionBuilder alertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
        return this;
    }

    /**
     * 设置客户端警告信息
     *
     * @param message 错误日志记录
     * @return this
     */
    public ServiceExceptionBuilder message(String message) {
        this.message = message;
        return this;
    }

    /**
     * 构建 ServiceException
     *
     * @return ServiceException
     */
    public ServiceException build() {
        analysis();
        switch (buildMode) {
            case 1:
                return new ServiceException(message, cause);
            case 2:
                return new ServiceException(code, message, cause);
            case 3:
                return new ServiceException(alertMessage, message, cause);
            case 4:
                return new ServiceException(code, alertMessage, message, cause);
            default:
                throw new RuntimeException("ServiceException 构建失败");
        }
    }

    /**
     * 解析构造信息
     * 1: 无客户端告警提示, 无错误码
     * 2: 无客户端告警提示, 含错误码
     * 3: 含客户端告警提示, 无错误码
     * 4: 含客户端告警提示, 含错误码
     */
    private void analysis() {
        if (StringUtils.isBlank(alertMessage) && Objects.isNull(code)) {
            buildMode = 1;
        }
        if (StringUtils.isBlank(alertMessage) && Objects.nonNull(code)) {
            buildMode = 2;
        }
        if (StringUtils.isNotBlank(alertMessage) && Objects.isNull(code)) {
            buildMode = 3;
        }
        if (StringUtils.isNotBlank(alertMessage) && Objects.nonNull(code)) {
            buildMode = 4;
        }
    }

}
