package com.ztom.webmagic.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * author:ztom
 * date:2018/10/27 10:28
 */
public class MyProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public static int count = 0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        if (!page.getUrl().regex("https://blog.csdn.net/chinahnwqf/article/details/[0-9]{8}").match()) {
            page.addTargetRequests(
                    page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[@class=\"article-list\"]/div/h4/a").links().all());
        } else {
            System.out.println("抓取的内容:" +
                    page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div/div/div/div/h1/text()").get()
            );
            count++;
        }

    }
}
