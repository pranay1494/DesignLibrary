package com.customview.pranay.designlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Pranay on 06-01-2017.
 */
public class DynamicRadioGroup extends AppCompatActivity{

    private RadioGroup radioGroup;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobtn);

        radioGroup = (RadioGroup) findViewById(R.id.radiogrp);
        button = (Button) findViewById(R.id.btn);

        radioGroup.removeAllViews();
        for(int i=0;i<3;i++ ){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText("Radio Btn "+i);
            radioButton.setId(i);
            radioGroup.addView(radioButton);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton rBtn = (RadioButton) findViewById(id);
                Toast.makeText(DynamicRadioGroup.this, rBtn.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
