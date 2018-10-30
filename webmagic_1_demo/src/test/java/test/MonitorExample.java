package test;

import com.ztom.webmagic.processor.MyProcessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;

/**
 * author:ztom
 * date:2018/10/28 10:44
 */
public class MonitorExample {

    public static void main(String[] args) throws Exception {
        Spider spider = Spider.create(new MyProcessor())
                .addUrl("https://blog.csdn.net/chinahnwqf");

        SpiderMonitor.instance().register(spider);
        spider.start();
    }
}
