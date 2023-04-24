package com.test.test.api;


import com.test.test.models.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequestData {
    @GET("alerts/active?status=actual&message_type=alert")
    Call<Root> getData();
}
