package com.learn.base.response;

public class CatResponse<T> {
    private T data;
    private Status status;
    private String message;

    public CatResponse(Status status, T data, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static <T> CatResponse<? extends T> success(T data) {
        return new CatResponse<T>(Status.SUCCESS, data, null);
    }

    public static <T> CatResponse<? extends T> error(T data, String msg) {
        return new CatResponse<T>(Status.ERROR, data, msg);
    }

    public static <T> CatResponse<? extends T> loading(T data, String msg) {
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
