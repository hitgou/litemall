package com.hitgou.common.message;

public interface BusinessCallback<T> {
    public void onSuccess(T result);

    public void onTimeout();

}