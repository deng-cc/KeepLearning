package com.zker.common.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * zker 图友网模拟项目
 * FileName:BusinessException
 * <p>业务处理的异常类</p>
 *
 * @author Dulk
 * @version 1.00 16-10-6 Dulk
 */
public class BusinessException extends NestedRuntimeException {
    private static final long serialVersionUID = 1L;
    private String busMessage;

    public String getBusMessage() {
        return busMessage;
    }

    public void setBusMessage(String busMessage) {
        this.busMessage = busMessage;
    }

    /**
     * 构造方法
     */
    public BusinessException() {
        super("出现数据访问错误，请与系统管理员联系");
        this.busMessage="出现数据访问错误，请与系统管理员联系";
    }

    /**
     * 构造方法
     * @param message
     */
    public BusinessException(String message) {
        super(message);
        this.busMessage = message;
    }

    /**
     * 构造方法
     * @param message
     * @param cause
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.busMessage = message;
    }
}
