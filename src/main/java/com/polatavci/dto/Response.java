package com.polatavci.dto;

import lombok.Data;

@Data
public class Response<T> {
    private boolean isSuccess;
    private String message;
    private T data;

    private Response(boolean isSuccess, String message, T data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<T>(true, null, data);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<T>(false, message, null);
    }

}
