package com.quy.ab1;

import java.io.Serializable;

public class Donut implements Serializable {
    private int image;
    private String header;
    private String description;
    private String prices;

    public Donut(int image, String header, String description, String prices) {
        this.image = image;
        this.header = header;
        this.description = description;
        this.prices = prices;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}
