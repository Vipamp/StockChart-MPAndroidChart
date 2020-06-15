package com.android.stockapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.stockapp.R;
import com.android.stockapp.application.MyApplication;
import com.android.stockapp.ui.market.activity.StockDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_test)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        button.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, StockDetailActivity.class));
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MyApplication.getApplication().initDayNight();
    }
}
