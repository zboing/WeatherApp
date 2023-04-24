package com.test.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.test.test.models.DataModel;
import com.test.test.repository.DataRepository;

import java.util.List;


public class DataViewModel extends AndroidViewModel {
    private DataRepository repository;

    public DataViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);
    }

    public LiveData<List<DataModel>> getData() {
        return repository.getData();
    }

}
