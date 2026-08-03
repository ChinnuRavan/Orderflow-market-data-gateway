package com.orderflow.marketdatagateway.model;

public class PriceLevel {

    private double price;
    private int volume;

    public PriceLevel() {
    }

    public PriceLevel(double price, int volume) {
        this.price = price;
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}