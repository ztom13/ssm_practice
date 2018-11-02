package com.ztom.webmagic.journey;

/**
 * author:ztom
 * date:2018/10/31 19:16
 */
public class Product {
    private String productName;
    private String cityName;
    private String productPrice;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productName='").append(productName).append('\'');
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append(", productPrice='").append(productPrice).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
