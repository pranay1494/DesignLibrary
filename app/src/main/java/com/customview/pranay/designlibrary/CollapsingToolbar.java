package com.customview.pranay.designlibrary;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Pranay on 04-01-2017.
 */

/**
 * https://guides.codepath.com/android/Handling-Scrolls-with-CoordinatorLayout
 * http://stackoverflow.com/questions/27238433/when-should-one-use-theme-appcompat-vs-themeoverlay-appcompat
 */
public class CollapsingToolbar extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbar);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        if(getSupportActionBar()!=null) {
            setSupportActionBar(toolbar);
            ActionBar bar = getSupportActionBar();
            bar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.white));
        collapsingToolbar.setTitle("Yes Did It");
    }

    @Override
    protected void onStart() {
        super.onStart();
        /**
         * bcoz i was getting getsupportactionbar as null.
         * http://stackoverflow.com/questions/11802467/getsupportactionbar-return-null
         */
        if(getSupportActionBar()!=null) {
            setSupportActionBar(toolbar);
            ActionBar bar = getSupportActionBar();
            bar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
