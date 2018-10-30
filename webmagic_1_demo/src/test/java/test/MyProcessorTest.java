package test;

import com.ztom.webmagic.processor.MyProcessor;
import com.ztom.webmagic.processor.ProcessorDemo;
import org.junit.Test;
import us.codecraft.webmagic.Spider;

import java.io.File;

/**
 * author:ztom
 * date:2018/10/27 11:46
 */
public class MyProcessorTest {

    @Test
    public void myProcessorTest() {
        MyProcessor myProcessor = new MyProcessor();
        System.out.println("开始");
        long start = System.currentTimeMillis();
        Spider.create(myProcessor).addUrl("https://blog.csdn.net/chinahnwqf").thread(5).run();
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + ",个数:" + MyProcessor.count);

    }

    @Test
    public void demoTest() {
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(new ProcessorDemo()).addUrl("https://www.cnblogs.com/").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了" + ProcessorDemo.count + "条记录");
    }
}
