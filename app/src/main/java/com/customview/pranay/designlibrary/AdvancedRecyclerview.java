package com.customview.pranay.designlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import Model.RecyclerModel;
import adapter.RecyclerviewAdapter;
import dummyData.DummyData;

/**
 * Created by Pranay on 14-01-2017.
 */
public class AdvancedRecyclerview extends AppCompatActivity{
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.advanced_recyclerview);
        DummyData data = new DummyData();
        List<RecyclerModel> list = data.getImages();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }
}
