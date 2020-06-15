package com.github.mikephil.charting.module;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class OneDayData {

    String symbol;
    String name;
    String date;
    int amount;
    float open;
    float price;
    float high;
    float low;
    int vol;
    float yclose;
    List<MinuteData> minute;

    public static class MinuteData {
        int amount;
        float avprice;
        float high;
        float increase;
        float low;
        float open;
        float price;
        float risefall;
        int time;
        int vol;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public float getAvprice() {
            return avprice;
        }

        public void setAvprice(float avprice) {
            this.avprice = avprice;
        }

        public float getHigh() {
            return high;
        }

        public void setHigh(float high) {
            this.high = high;
        }

        public float getIncrease() {
            return increase;
        }

        public void setIncrease(float increase) {
            this.increase = increase;
        }

        public float getLow() {
            return low;
        }

        public void setLow(float low) {
            this.low = low;
        }

        public float getOpen() {
            return open;
        }

        public void setOpen(float open) {
            this.open = open;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public float getRisefall() {
            return risefall;
        }

        public void setRisefall(float risefall) {
            this.risefall = risefall;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getVol() {
            return vol;
        }

        public void setVol(int vol) {
            this.vol = vol;
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public float getYclose() {
        return yclose;
    }

    public void setYclose(float yclose) {
        this.yclose = yclose;
    }

    public void setMinute(List<MinuteData> minute) {
        this.minute = minute;
    }

    public List<MinuteData> getMinute() {
        return this.minute;
    }
}
