package com.github.mikephil.charting.module;

import java.util.List;

public class StockRTQuotationData {

    private String time;
    private String date;
    private float price;
    private float open;
    private float yclose;
    private float high;
    private float low;
    private int vol;
    private long amount;
    private float amplitude;// 振幅
    private float increase; //涨幅
    private float exchangerate;// 换手率
    private List<FiveMarketData> buy;
    private List<FiveMarketData> sell;

    public static class FiveMarketData {
        double price;
        int vol;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getVol() {
            return vol;
        }

        public void setVol(int vol) {
            this.vol = vol;
        }

        @Override
        public String toString() {
            return "FiveMarketData{" +
                    "price=" + price +
                    ", vol=" + vol +
                    '}';
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getYclose() {
        return yclose;
    }

    public void setYclose(float yclose) {
        this.yclose = yclose;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public float getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(float amplitude) {
        this.amplitude = amplitude;
    }

    public float getIncrease() {
        return increase;
    }

    public void setIncrease(float increase) {
        this.increase = increase;
    }

    public float getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(float exchangerate) {
        this.exchangerate = exchangerate;
    }

    public List<FiveMarketData> getBuy() {
        return buy;
    }

    public void setBuy(List<FiveMarketData> buy) {
        this.buy = buy;
    }

    public List<FiveMarketData> getSell() {
        return sell;
    }

    public void setSell(List<FiveMarketData> sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "StockRTQuotationData{" +
                "time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", open=" + open +
                ", yclose=" + yclose +
                ", high=" + high +
                ", low=" + low +
                ", vol=" + vol +
                ", amount=" + amount +
                ", amplitude=" + amplitude +
                ", increase=" + increase +
                ", exchangerate='" + exchangerate + '\'' +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
