package com.customview.pranay.designlibrary;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Pranay on 04-01-2017.
 */

/**
 * https://guides.codepath.com/android/Handling-Scrolls-with-CoordinatorLayout
 * http://stackoverflow.com/questions/27238433/when-should-one-use-theme-appcompat-vs-themeoverlay-appcompat
 *
 * your app won’t need to draw under the status bar or the navigation bar,
 * but if you do: you need to make sure interactive elements (like buttons) aren’t hidden underneath them.
 * That’s what the default behavior of the android:fitsSystemWindows=“true” attribute gives you: it sets the padding of
 * the View to ensure the contents don’t overlay the system windows.
 */
public class CollapsingToolbar extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbar);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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
