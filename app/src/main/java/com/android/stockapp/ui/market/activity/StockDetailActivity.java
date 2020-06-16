package com.android.stockapp.ui.market.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.android.stockapp.R;
import com.android.stockapp.common.adapter.SimpleFragmentPagerAdapter;
import com.android.stockapp.common.data.Constants;
import com.android.stockapp.common.viewpager.NoTouchScrollViewpager;
import com.android.stockapp.ui.market.fragment.ChartFiveDayFragment;
import com.android.stockapp.ui.market.fragment.ChartKLineFragment;
import com.android.stockapp.ui.market.fragment.ChartOneDayFragment;
import com.github.mikephil.charting.module.StockRTQuotationData;
import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.android.stockapp.common.utils.HttpRequestUtils.getStockRTQuotationData;

/**
 * 股票详情页
 */
public class StockDetailActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    NoTouchScrollViewpager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rightPanel)
    GridView rightGridView;
    @BindView(R.id.priceView)
    TextView priceView;
    @BindView(R.id.increView)
    TextView increView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String stockCode = "000001.sz";
        String stockName = "平安银行";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_detail);
        ButterKnife.bind(this);

        StockRTQuotationData stockRTQuotationData = getStockRTQuotationData(stockCode);
        showTopPanel(stockRTQuotationData);

        toolbar.setTitle(String.format("%s(%s)", stockName, stockCode.split("\\.")[0]));
        toolbar.inflateMenu(R.menu.menu_right);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_model:
                        SharedPreferences sp = getSharedPreferences(Constants.SP_FILE,
                                Context.MODE_PRIVATE);
                        if (!sp.getBoolean(Constants.DAY_NIGHT_MODE, false)) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            sp.edit().putBoolean(Constants.DAY_NIGHT_MODE, true).apply();
                            Toast.makeText(StockDetailActivity.this, "夜间模式!", Toast.LENGTH_SHORT).show();
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            sp.edit().putBoolean(Constants.DAY_NIGHT_MODE, false).apply();
                            Toast.makeText(StockDetailActivity.this, "白天模式!", Toast.LENGTH_SHORT).show();
                        }
                        recreate();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        Fragment[] fragments = {ChartOneDayFragment.newInstance(false, stockCode, stockName),
                ChartFiveDayFragment.newInstance(false, stockCode, stockName),
                ChartKLineFragment.newInstance(1, false, stockCode, stockName),
                ChartKLineFragment.newInstance(7, false, stockCode, stockName),
                ChartKLineFragment.newInstance(30, false, stockCode, stockName)};
        String[] titles = {"分时", "五日", "日K", "周K", "月K"};
        viewPager.setOffscreenPageLimit(fragments.length);
        viewPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);
    }

    @SuppressLint("SetTextI18n")
    private void showTopPanel(StockRTQuotationData stockRTQuotationData) {
        DecimalFormat d2 = new DecimalFormat("0.00");
        DecimalFormat d0 = new DecimalFormat("0");

        priceView.setText(stockRTQuotationData.getPrice() + "");
        increView.setText(d2.format(stockRTQuotationData.getIncrease()) + "%");
        if (stockRTQuotationData.getIncrease() >= 0) {
            priceView.setTextColor(Color.RED);
            increView.setTextColor(Color.RED);
        } else {
            priceView.setTextColor(Color.GREEN);
            increView.setTextColor(Color.GREEN);
        }

        List<String> rights = new ArrayList<>();
        rights.add("  昨    收  : " + stockRTQuotationData.getYclose());
        rights.add("  今    开  : " + stockRTQuotationData.getOpen());
        rights.add("  振    幅  : " + d2.format(stockRTQuotationData.getAmplitude()));
        rights.add("  最    高  : " + stockRTQuotationData.getHigh());
        rights.add("  最    低  : " + stockRTQuotationData.getLow());
        rights.add("  成交量  : " + d0.format(stockRTQuotationData.getVol() / 1000000) + "万手");
        rights.add("  成交额  : " + (stockRTQuotationData.getAmount() > 100000000 ? d2.format(stockRTQuotationData.getAmount() / 100000000) + "亿" : d0.format(stockRTQuotationData.getAmount() / 10000 + "万")));
        rights.add("  换手率  : " + d2.format(stockRTQuotationData.getExchangerate() * 100) + "%");
        ArrayAdapter<String> rightAdapter = new ArrayAdapter<>(this, R.layout.item, rights);
        rightGridView.setAdapter(rightAdapter);
    }
}
