package com.learn.base.di.module;

import com.learn.base.Config;
import com.learn.base.service.DatabaseService;
import com.learn.base.service.NetworkService;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

import static com.learn.base.Config.BASE_URL;

@Module
public class BaseModule {

    @Provides
    @Singleton
    DatabaseService provideDatabaseService() {
        return new DatabaseService();
    }

    @Provides
    @Singleton
    NetworkService provideNetworkService(Retrofit retrofit) {
        return new NetworkService(retrofit);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder.addInterceptor(loggingInterceptor);

        httpClientBuilder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("x-api-key", Config.TOKEN).build();
            return chain.proceed(request);
        });

        return new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}