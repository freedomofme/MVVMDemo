package com.learn.base.response;

import com.learn.base.utils.ErrorMessageUtils;

import retrofit2.Response;

public class CatResponse<T> {
    private T data;
    private Status status;
    private String message;

    private CatResponse(Status status, T data, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static <T> CatResponse<T> success(T data) {
        return new CatResponse<T>(Status.SUCCESS, data, null);
    }

    public static <T> CatResponse<T> error(Response<?> response) {
        return new CatResponse<T>(Status.ERROR, null, ErrorMessageUtils.getErrorFromResponse(response));
    }

    public static <T> CatResponse<T> error(Throwable response) {
        return new CatResponse<T>(Status.ERROR, null, ErrorMessageUtils.getErrorFromResponse(response));
    }

    public static <T> CatResponse<T> loading(T data, String msg) {
        return new CatResponse<T>(Status.LOADING, data, null);
    }

    public T getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }


}
