package com.ztom.domain;

/**
 * author:ztom
 * date:2018/10/28 13:18
 */
public class Hero {
    private Integer heroId;
    private String heroName;
    private Float price;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hero{");
        sb.append("heroId=").append(heroId);
        sb.append(", heroName='").append(heroName).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
