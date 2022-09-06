package com.example.githubissueapplication.api;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/// singolton class for retrofit///
public class RetrofitClient {

    private static final String Base_url = "https://api.github.com/repos/square/okhttp/";   //  for get url

    private static RetrofitClient mInstance;
    private final OkHttpClient client;
    private Retrofit retrofit;


    private RetrofitClient(){
      client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .build();

        retrofit=new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    public static synchronized RetrofitClient getInstance(){
        if (mInstance==null){
            mInstance=new RetrofitClient();
        }
        return mInstance;
    }


    public Apis getApi(){
        return  retrofit.create(Apis.class);
    }
}
