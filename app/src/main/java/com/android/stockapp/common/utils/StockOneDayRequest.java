package com.android.stockapp.common.utils;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StockOneDayRequest extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String res = "";
        String stockCode = strings[0];
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8,text/plain");
            RequestBody body = RequestBody.create(mediaType, "field%5B%5D=name&field%5B%5D=symbol&field%5B%5D=yclose&field%5B%5D=open&field%5B%5D=price&field%5B%5D=high&field%5B%5D=low&field%5B%5D=vol&field%5B%5D=amount&field%5B%5D=date&field%5B%5D=time&field%5B%5D=minute&field%5B%5D=minutecount&symbol%5B%5D=000001.sz&start=-1");
            Request request = new Request.Builder()
                    .url("https://opensource.zealink.com/API/Stock")
                    .method("POST", body)
                    .addHeader("authority", "opensource.zealink.com")
                    .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
                    .addHeader("content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                    .addHeader("origin", "https://opensource.zealink.com")
                    .addHeader("sec-fetch-site", "same-origin")
                    .addHeader("referer", "https://opensource.zealink.com/vuehqweb/hq.demo.page.html")
                    .addHeader("accept-language", "zh-CN,zh;q=0.9")
                    .addHeader("Cookie", "SERVERID=b4bbcc194bd11f79a2fe42bf20e56e2f|1592234352|1592234352")
                    .build();
            Response response = client.newCall(request).execute();
            byte[] bytes = response.body().bytes();
            res = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
