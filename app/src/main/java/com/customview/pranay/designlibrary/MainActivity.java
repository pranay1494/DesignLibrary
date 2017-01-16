package com.customview.pranay.designlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    String nameOfClasses[] = {"Collapsing Toolbar","Dynamic Radio Group","Advanced RecyclerView","View Anchoring"};
    private Class classes[] = {CollapsingToolbar.class,DynamicRadioGroup.class,AdvancedRecyclerview.class,ViewAnchoring.class};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameOfClasses));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this,classes[i]));
            }
        });
    }
}
