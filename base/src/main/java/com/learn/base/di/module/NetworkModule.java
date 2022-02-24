package com.learn.base.di.module;

import com.learn.base.Config;
import com.learn.base.service.NetworkService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

import static com.learn.base.Config.BASE_URL;

@Module
public class NetworkModule {

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