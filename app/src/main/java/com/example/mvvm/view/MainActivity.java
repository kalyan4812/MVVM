package com.example.mvvm.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.R;
import com.example.mvvm.viewmodel.CommonViewModel;
import com.example.mvvm.viewmodel.CommonViewModelImplementor;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    ListView listView;
    CommonViewModel commonViewModelImplementor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listview);
        commonViewModelImplementor= new ViewModelProvider(this).get(CommonViewModelImplementor.class);
        getLifecycle().addObserver(commonViewModelImplementor);
        commonViewModelImplementor.getitems().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, strings);
                listView.setAdapter(arrayAdapter);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonViewModelImplementor.addItem(editText.getText().toString());
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent newActivityIntent = new Intent(getApplicationContext(), SecondActivity.class);
                newActivityIntent.putExtra("todoId", parent.getItemAtPosition(position).toString());
                startActivity(newActivityIntent);
            }
        });

    }


}
