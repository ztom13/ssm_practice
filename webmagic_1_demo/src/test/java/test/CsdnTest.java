package test;

import com.ztom.webmagic.csdnblog.CSDNBlogProcessor;
import com.ztom.webmagic.processor.CsdnBlogPageProcessor;
import org.junit.Test;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

/**
 * author:ztom
 * date:2018/10/28 23:16
 */
public class CsdnTest {
    @Test
    public void test() {
        long startTime, endTime;
        System.out.println("【爬虫开始】请耐心等待一大波数据到你碗里来...");
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new CsdnBlogPageProcessor()).addUrl("http://blog.csdn.net/" + CsdnBlogPageProcessor.username).thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】共抓取" + CsdnBlogPageProcessor.size + "篇文章，耗时约" + ((endTime - startTime) / 1000) +
                "秒，已保存到数据库，请查收！");
    }

    @Test
    public void testMine() {
        long startTime, endTime;
        Site site = Site.me().setRetryTimes(3).setSleepTime(100);
//        String username = "weixin_43147371";
        String username = "qq598535550";
        System.out.println("【爬虫开始】请耐心等待一大波数据到你碗里来...");
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new CSDNBlogProcessor(username,site)).addUrl("https://blog.csdn.net/"+username).thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】共抓取" + CSDNBlogProcessor.size + "篇文章，耗时约" + ((endTime - startTime) / 1000) +
                "秒，已保存到数据库，请查收！");
    }
}
