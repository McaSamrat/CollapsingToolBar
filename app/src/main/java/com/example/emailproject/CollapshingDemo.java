package com.example.emailproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollapshingDemo extends AppCompatActivity {

    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView coverImage;
    private Toolbar mToolbar;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapshing_demo);
        findViews();
        collapsing.setTitle("Collapsing ToolBar");
        setSupportActionBar(mToolbar);
        onClickListener();
    }

    private void findViews() {
        mToolbar = findViewById(R.id.toolbar);
        appbar = findViewById(R.id.appBarLayout);
        collapsing = findViewById(R.id.collapsingLayout);
        coverImage = findViewById(R.id.imagePlaceholder);
    }

    private void onClickListener() {

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
           boolean isShow = false;
           int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + i == 0){
                    isShow = true;
                    showOption(R.id.action_info);
                }else if (isShow){
                    isShow = false;
                    hideOption(R.id.action_info);
                }
            }
        });

    }

    private void showOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        hideOption(R.id.action_info);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }else if (id == R.id.action_info){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void hideOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(false);
    }

}
