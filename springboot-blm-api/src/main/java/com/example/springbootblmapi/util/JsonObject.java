package com.example.springbootblmapi.util;

/**
 *
 */
public class JsonObject<T> extends AbstractJsonObject {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
