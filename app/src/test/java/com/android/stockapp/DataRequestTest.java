package com.android.stockapp;

import com.android.stockapp.common.utils.HttpRequestUtils;
import com.github.mikephil.charting.module.OneDayData;
import com.github.mikephil.charting.module.StockRTQuotationData;

import org.junit.Test;

public class DataRequestTest {

    @Test
    public void getStockOneDayDataTest() {
        OneDayData oneDayData = HttpRequestUtils.getStockOneDayData("000001.sz");
        System.out.println(oneDayData);
    }

    @Test
    public void getStockRTQuotationDataTest() {
        StockRTQuotationData stockRTQuotationData = HttpRequestUtils.getStockRTQuotationData("000001.sz");
        System.out.println(stockRTQuotationData);
    }

    @Test
    public void test() {
        String code = "000001.sz";
        System.out.println(code.split("\\.")[0]);
    }
}
