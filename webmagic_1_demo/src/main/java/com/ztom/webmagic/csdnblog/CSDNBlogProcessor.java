package com.ztom.webmagic.csdnblog;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * author:ztom
 * date:2018/10/29 13:08
 */
public class CSDNBlogProcessor implements PageProcessor {
    public static Integer size = 0;

    private String username;

    private Site site;

    public CSDNBlogProcessor(String username, Site site) {
        this.username = username;
        this.site = site;
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        // 判断链接是否为文章页面
        if (!page.getUrl().regex("https://blog.csdn.net/"+username+"/article/details/\\d+").match()){
            // 是文章列表页面,添加文章链接到请求中
            System.out.println("添加链接:"+page.getHtml().xpath("//div[@class=\"article-list\"]/div/h4/a").links().all());
            page.addTargetRequests(
                    page.getHtml().xpath("//div[@class=\"article-list\"]/div/h4/a").links().all());
        }else {
            //是文章详情页

            size++;
            CsdnBlog csdnBlog = new CsdnBlog();

            // 文章编号
            String number = page.getUrl().regex("https://blog.csdn.net/"+username+"/article/details/(\\d+)").toString();
            System.out.println("编号:"+number);
            csdnBlog.setArticle_number(Integer.parseInt(number));

            // 文章标题
            String title = page.getHtml().xpath("//h1[@class='title-article']/text()").toString();
            System.out.println("标题:"+title);
            csdnBlog.setArticle_title(title);

            // 文章作者
            String author = page.getHtml().xpath("//a[@class='follow-nickName']/text()").toString();
            System.out.println("作者:"+author);
            csdnBlog.setAuthor_name(author);

            // 文章阅读量
            String readNumber = page.getHtml().xpath("//span[@class='read-count']/text()").toString();
            System.out.println(readNumber);
            csdnBlog.setRead_number(readNumber);

            // 文章发布时间
            String time = page.getHtml().xpath("//span[@class='time']/text()").toString();
            System.out.println("发布时间:"+time);
            csdnBlog.setDeploy_time(time);

            System.out.println(csdnBlog);
        }
    }
}
