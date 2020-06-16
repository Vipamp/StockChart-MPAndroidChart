package com.android.stockapp.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.mikephil.charting.module.OneDayData;
import com.github.mikephil.charting.module.StockRTQuotationData;

import java.util.Map;

public class HttpRequestUtils {

    public static OneDayData getStockOneDayData(String stockCode) {
        String res = new StockOneDayRequest().doInBackground(stockCode);
        Map map = (Map) JSON.parse(res);
        String resStr = JSON.toJSONString(map.get("stock"));
        return JSONObject.parseObject(resStr.substring(1, resStr.length() - 1), OneDayData.class);
    }

    public static StockRTQuotationData getStockRTQuotationData(String stockCode) {
        String res = new StockRTQuotationRequest().doInBackground(stockCode);
        Map map = (Map) JSON.parse(res);
        String resStr = JSON.toJSONString(map.get("stock"));
        return JSONObject.parseObject(resStr.substring(1, resStr.length() - 1), StockRTQuotationData.class);
    }
}
