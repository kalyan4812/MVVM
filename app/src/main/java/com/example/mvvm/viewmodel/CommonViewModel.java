package com.example.mvvm.viewmodel;

import android.content.Intent;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;

import java.util.List;

public interface CommonViewModel extends LifecycleObserver {
    LiveData<List<String>> getitems();
    void addItem(String s);
    void alertbox(String s);
    void resumelistener();
}
