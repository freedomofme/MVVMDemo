package com.learn.base.utils;

import androidx.annotation.NonNull;

import java.io.IOException;

import retrofit2.Response;

public class ErrorMessageUtils {
    public static <T> String getErrorFromResponse(Response<T> response) {
        if (response == null || response.isSuccessful()) {
            return null;
        }
        String msg = null;
        try {
            msg = response.errorBody() == null ? null : response.errorBody().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg == null) msg = response.message();

        return msg;
    }

    public static String getErrorFromResponse(@NonNull Throwable throwable) {
         return throwable.toString();
    }
}
