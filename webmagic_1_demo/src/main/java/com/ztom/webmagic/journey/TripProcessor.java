package com.ztom.webmagic.journey;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * author:ztom
 * date:2018/10/31 18:02
 */
public class TripProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        if(!page.getUrl().regex("https://www.uzai.com/tours/[0-9]{8}.html").match()){
            page.addTargetRequests(
                    page.getHtml().xpath("//a[@class='main2_m_right_li']").links().all()
            );
        }else {
            Product product = new Product();

            String productName = page.getHtml().xpath("//h2[@class='title']/text()").toString();
            product.setProductName(productName);

            String cityName = page.getHtml().xpath("//div[@class='main_right']/div/div/span/text()").toString();
            product.setCityName(cityName);

            String productPrice = page.getHtml().xpath("//div[@class='main_right1']/div[@class='n1']/label[@id='price']/text()").toString();
            product.setProductPrice(productPrice);

            System.out.println(product);
        }
    }

    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(3).setSleepTime(100);
    }

    public static void main(String[] args) {
        Spider.create(new TripProcessor()).addUrl("https://www.uzai.com/lvyoucn/bj/").thread(5).run();
    }
}
