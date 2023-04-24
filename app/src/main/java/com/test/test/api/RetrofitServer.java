package com.test.test.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {

    private static Retrofit retrofit = null;

    public static ApiRequestData getRetrofitServer() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://api.weather.gov/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiRequestData.class);
    }

}
