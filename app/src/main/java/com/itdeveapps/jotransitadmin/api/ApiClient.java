package com.itdeveapps.jotransitadmin.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Omar Al-Tamimi on 3/3/2017.
 */

public class ApiClient {

    private static volatile ApiClient mInstance;
    private ApiService mApiService;
    private static final int TIMEOUT = 40; //SECONDS
    private Gson mGson;

    private ApiClient() {
        mGson = new GsonBuilder().create();
        OkHttpClient okClient = getOkClient();
        RxJavaCallAdapterFactory rxAdapter =
                RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        Retrofit retrofit = new Retrofit.Builder()
                .client(okClient)
                .baseUrl("http://192.168.1.240:8080"/*"http://custom-env.hxkrxm5r4q.us-west-2
                .elasticbeanstalk.com"*/)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(rxAdapter).build();
        mApiService = retrofit.create(ApiService.class);
    }

    public static ApiClient getInstance() {
        if (mInstance == null) {
            synchronized (ApiClient.class) {
                if (mInstance == null) {
                    mInstance = new ApiClient();
                }
            }
        }
        return mInstance;
    }


    public ApiService getApiService() {
        return mApiService;
    }

    private OkHttpClient getOkClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        okHttpClientBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        logging.setLevel(
                HttpLoggingInterceptor.Level.BODY);
        okHttpClientBuilder.addInterceptor(logging);

        return okHttpClientBuilder.build();
    }

    public Gson getGson() {
        return mGson;
    }
}
