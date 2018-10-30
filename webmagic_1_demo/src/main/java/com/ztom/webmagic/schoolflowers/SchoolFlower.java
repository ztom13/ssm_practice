package com.ztom.webmagic.schoolflowers;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ztom
 * date:2018/10/28 22:41
 */
public class SchoolFlower implements PageProcessor {

    //页面URL的正则表达式
    //.是匹配所有的字符，//.表示只匹配一个，//.?同理
    private static String REGEX_PAGE_URL = "http://www.521609.com/daxuexiaohua/list\\w+.html";
    //爬取的页数
    private static int PAGE_SIZE = 358;
    //下载张数
    private static int INDEX_PHOTO = 0;

    //配置
    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(3).setSleepTime(100);
    }

    @Override
    public void process(Page page) {
        List<String> targetURL = new ArrayList<>();

        for (int i = 310; i < PAGE_SIZE; i++)
            //添加到目标url中
            targetURL.add("http://www.521609.com/daxuexiaohua/list" + i + ".html");
        //添加url到请求中,打开图片列表页面
        page.addTargetRequests(targetURL);

        if (page.getUrl().regex(REGEX_PAGE_URL).match()) {
            //是图片列表页面

            //爬取所有详情页的连接
            //page.getHtml().xpath("//a[@class=\"title\"]").links().all();
            List<String> detailURL = page.getHtml().xpath("//a[@class='title']").links().all();
            System.out.println("size:" + detailURL.size());
            for (String str : detailURL) {
                //输出所有连接
                System.out.println(str);
            }
            //添加url到请求中,打开详情页
            page.addTargetRequests(detailURL);

        } else {
            //是详情页

            //按条件筛选: 点赞数
            String diggNum = page.getHtml().xpath("//div[@class='digg_num']/text()").regex("\\d+").toString();
            //点赞数要超过200
            if (Integer.parseInt(diggNum) > 200) {
                //爬取图片的url
                String photoURL = page.getHtml().xpath("//div[@class='picbox']/a").css("img", "src").toString();
                System.out.println(photoURL);
                //爬取名字
                String nickname = page.getHtml().xpath("//div[@class='title']/h2/text()").toString();
                System.out.println(nickname);

                try {
                    // 根据图片URL 下载图片方法
                    /**
                     * @param urlStr 图片URL地址
                     * @param filename 图片名称
                     * @param savePath 保存路径
                     */
                    SpiderDownload.download("http://www.521609.com" + photoURL,
                            nickname + ".jpg",
                            "/Users/ztom/Pictures/spider/");
                    System.out.println("第" + (INDEX_PHOTO++) + "张");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] arv) {
        //起始URL，开启的线程数为10个
        Spider.create(new SchoolFlower()).addUrl("http://www.521609.com/daxuexiaohua/list310.html").thread(10).run();

    }

}
