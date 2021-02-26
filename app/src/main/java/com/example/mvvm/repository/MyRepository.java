package com.example.mvvm.repository;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public interface MyRepository extends LifecycleObserver {
    MutableLiveData<List<String>> getitems();
    void addItem(String s);
}
