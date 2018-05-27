package com.android.stockapp.ui.market.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.android.stockapp.R;
import com.android.stockapp.common.adapter.SimpleFragmentPagerAdapter;
import com.android.stockapp.common.viewpager.NoTouchScrollViewpager;
import com.android.stockapp.ui.market.fragment.ChartKLineFragment;
import com.android.stockapp.ui.market.fragment.ChartTimeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 股票详情页-横屏
 */
public class StockDetailLandActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    NoTouchScrollViewpager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_detail_land);
        ButterKnife.bind(this);

        Fragment[] fragments = {ChartTimeFragment.newInstance(1,true), ChartTimeFragment.newInstance(5,true),
                ChartKLineFragment.newInstance(1,true), ChartKLineFragment.newInstance(7,true),
                ChartKLineFragment.newInstance(30,true)};
        String[] titles = {"分时", "五日", "日K", "周K", "月K"};
        viewPager.setOffscreenPageLimit(fragments.length);
        viewPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);
    }
}