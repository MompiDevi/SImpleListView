package com.example.recyclerviewwcreation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewwcreation.Adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (RecyclerView)findViewById(R.id.list);
        String[] data = {"Test 1","Test 2", "Test 3", "Test 4"};
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this, data);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
    }
}
