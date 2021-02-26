package com.example.mvvm.viewmodel;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.repository.MyRepository;
import com.example.mvvm.repository.MyRepositoryImplementor;

import java.util.List;

public class CommonViewModelImplementor extends ViewModel implements CommonViewModel {


    private MyRepository myRepositoryImplementor;
    MutableLiveData<List<String>> mutableLiveData;
    public CommonViewModelImplementor(){
        myRepositoryImplementor=MyRepositoryImplementor.getInstance();
        mutableLiveData=myRepositoryImplementor.getitems();
    }
    @Override
    public LiveData<List<String>> getitems() {
        return mutableLiveData;
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    @Override
    public void resumelistener() {
        mutableLiveData.setValue(myRepositoryImplementor.getitems().getValue());
        Log.i("log","onresume ");
    }

    @Override
    public void addItem(String s) {
      myRepositoryImplementor.addItem(s);
      mutableLiveData.setValue(myRepositoryImplementor.getitems().getValue());
    }

    @Override
    public void alertbox(String s) {

    }
}
