package com.hitgou.common.message;

import java.io.Serializable;

public class MessageInfo implements Serializable {
    private static final long serialVersionUID = 8804172869159997553L;

    public final static int MessageTypeUser = 1;
    public final static int MessageTypeGroup = 2;
    public final static int MessageTypeAll = 3;

    private Integer userId;
    private int messageType = MessageTypeUser;
    private String eventType;
    private String extra;

    public MessageInfo() {

    }

    public MessageInfo(Integer userId, String eventType) {
        this(userId, MessageTypeUser, eventType, null);
    }

    public MessageInfo(Integer userId, String eventType, String extra) {
        this(userId, MessageTypeUser, eventType, extra);
    }

    public MessageInfo(Integer userId, int messageType, String eventType) {
        this(userId, messageType, eventType, null);
    }

    public MessageInfo(Integer userId, int messageType, String eventType, String extra) {
        this.setUserId(userId);
        this.setEventType(eventType);
        this.setExtra(extra);
        this.setMessageType(messageType);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

}