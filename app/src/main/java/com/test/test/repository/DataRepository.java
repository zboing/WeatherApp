package com.test.test.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.test.test.api.ApiRequestData;
import com.test.test.api.RetrofitServer;
import com.test.test.models.DataModel;
import com.test.test.models.Properties;
import com.test.test.models.Root;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataRepository {
    private ArrayList<DataModel> modelList = new ArrayList<>();
    private MutableLiveData<List<DataModel>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public DataRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<DataModel>> getData() {
        //Log.d("@@@","modelList "+ modelList.size());
        if (modelList.size() > 0) {
            return mutableLiveData;
        }
        ApiRequestData apiService = RetrofitServer.getRetrofitServer();
        Call<Root> call = apiService.getData();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                //Log.d("@@@","response "+response);
                if (response.body() != null && response.isSuccessful()) {
                    //Log.d("@@@","received");
                    for (int i = 0; i < response.body().getFeatures().size(); i++){
                        Properties row = response.body().getFeatures().get(i).getProperties();
                        modelList.add(new DataModel(row.getEvent(), row.getSenderName(), timeBetween(row.getEffective(), row.getEnds())));
                    }
                    mutableLiveData.setValue(modelList);
                } else {
                    mutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

    private String timeBetween(Date date1, Date date2) {
        String time = "";
        if (date1 != null && date2 != null) {
            try {
                long diff = date2.getTime() - date1.getTime();
                long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                long minutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
                if (days == 0)
                    time = "" + minutes + " min";
                else
                    time = "" + days + " days";
            } catch (Exception e) {
                time = "ex";
                e.printStackTrace();
            }
        } else {
            time = "?";
        }
        return time;
    }
}
