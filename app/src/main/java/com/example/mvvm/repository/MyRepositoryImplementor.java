package com.example.mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.ModelAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyRepositoryImplementor implements MyRepository {

   static MyRepositoryImplementor myRepositoryImplementor;
    MutableLiveData<List<String>> mutableitems;
    List<String> myitems;
    ModelAdapter modelAdapter;
    public static MyRepositoryImplementor getInstance(){
        if(myRepositoryImplementor==null){
            myRepositoryImplementor=new MyRepositoryImplementor();
        }
        return myRepositoryImplementor;
    }
    public MyRepositoryImplementor(){
        modelAdapter=new ModelAdapter();
        myitems=new ArrayList<>();
        mutableitems=new MutableLiveData<>();

    }
    @Override
    public MutableLiveData<List<String>> getitems() {
        myitems=modelAdapter.getAllToDos();
        mutableitems.setValue(myitems);
        return mutableitems;
    }

    @Override
    public void addItem(String s) {
      modelAdapter.addItem(s);
    }
}
