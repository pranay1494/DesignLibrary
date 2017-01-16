package com.customview.pranay.designlibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

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
 *
 *
 * when the Statusbar is transparent the layout will use its height. To prevent this we just need to: http://stackoverflow.com/questions/29907615/android-transparent-status-bar-and-actionbar
    SOLUTION ONE:
    Add this line android:fitsSystemWindows="true" in your layout view container of whatever you want to be placed bellow the Actionbar:
 */
public class CollapsingToolbar extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView ivCollapsingtoolbar;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbar);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        ivCollapsingtoolbar = (ImageView) findViewById(R.id.ivCollapsingtoolbar);

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

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
//        collapsingToolbar.setTitle("Yes Did It");

        setColors();
        setStatusBarTranslucent(true);
    }

    private void setColors() {
        Bitmap bitmap = ((BitmapDrawable) ivCollapsingtoolbar.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int primaryDark = getResources().getColor(R.color.colorPrimaryDark);
                int primary = getResources().getColor(R.color.colorPrimary);
                collapsingToolbar.setContentScrimColor(palette.getVibrantColor(primary));
                collapsingToolbar.setStatusBarScrimColor(palette.getDarkVibrantColor(primaryDark));
                collapsingToolbar.setCollapsedTitleTextColor(palette.getDarkMutedColor(primaryDark));
                //setStatusbarcolor(palette.getDarkVibrantColor(primaryDark));
            }
        });
    }

    private void setStatusbarcolor(int darkVibrantColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = ContextCompat.getColor(this, darkVibrantColor);

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }
    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
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
