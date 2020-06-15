package com.android.stockapp;

import com.android.stockapp.common.utils.HttpRequestUtils;
import com.github.mikephil.charting.module.OneDayData;

import org.junit.Test;

public class DataRequestTest {

    @Test
    public void addition_isCorrect() {
        OneDayData oneDayData = HttpRequestUtils.getStockOneDayData("000001.sz");
        System.out.println(oneDayData);
    }
}
