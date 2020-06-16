package com.android.stockapp.common.utils;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StockRTQuotationRequest extends AsyncTask<String, Void, String> {

    static OkHttpClient client = new OkHttpClient().newBuilder().build();
    static StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    static {
        StrictMode.setThreadPolicy(policy);
    }

    Request.Builder build = new Request.Builder()
            .url("https://opensource.zealink.com/API/Stock")
            .addHeader("authority", "opensource.zealink.com")
            .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
            .addHeader("content-type", "application/x-www-form-urlencoded;charset=UTF-8")
            .addHeader("origin", "https://opensource.zealink.com")
            .addHeader("sec-fetch-site", "same-origin")
            .addHeader("referer", "https://opensource.zealink.com/vuehqweb/hq.demo.page.html")
            .addHeader("accept-language", "zh-CN,zh;q=0.9")
            .addHeader("Cookie", "SERVERID=b4bbcc194bd11f79a2fe42bf20e56e2f|1592234352|1592234352");

    @Override
    protected String doInBackground(String... strings) {
        String res = "";
        String stockCode = strings[0];
        try {
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8,text/plain");
            RequestBody body = RequestBody.create(mediaType, "field%5B%5D=name&field%5B%5D=symbol&field%5B%5D=yclose&field%5B%5D=open&field%5B%5D=price&field%5B%5D=high&field%5B%5D=low&field%5B%5D=vol&field%5B%5D=amount&field%5B%5D=date&field%5B%5D=time&field%5B%5D=week&field%5B%5D=increase&field%5B%5D=buy&field%5B%5D=sell&field%5B%5D=exchangerate&field%5B%5D=amplitude&symbol%5B%5D=" + stockCode);
            Request request = build.method("POST", body).build();
            Response response = client.newCall(request).execute();
            byte[] bytes = response.body().bytes();
            res = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
