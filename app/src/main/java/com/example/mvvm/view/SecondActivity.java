package com.example.mvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.R;
import com.example.mvvm.viewmodel.CommonViewModel;
import com.example.mvvm.viewmodel.CommonViewModelImplementor;


public class SecondActivity extends AppCompatActivity {
    TextView textView;
    Button alert;
   CommonViewModel commonViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);
        alert = findViewById(R.id.alert);
        commonViewModel=new ViewModelProvider(this).get(CommonViewModelImplementor.class);
        getLifecycle().addObserver(commonViewModel);
        textView.setText(getIntent().getStringExtra("todoId"));
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonViewModel.addItem("SAI KALYAN");
                Toast.makeText(getApplicationContext(),"SAI KALYAN",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
