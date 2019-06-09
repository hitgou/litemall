package org.linlinjava.litemall.core.system;

import java.io.Serializable;

/**
 * Created by Colin on 2018-02-25
 */
public class MessageException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 错误级别
     */
    private Integer status;

    /**
     * 错误状态
     */
    private Integer state;

    public MessageException(int state, String message) {
        this(1, state, message);
    }

    public MessageException(int status, int state, String message) {
        super(message);

        this.status = status;
        this.setState(state);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
