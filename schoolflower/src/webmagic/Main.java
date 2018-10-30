package webmagic;

import us.codecraft.webmagic.Spider;

import javax.swing.*;

/**
 * author:ztom
 * date:2018/10/29 11:13
 */
public class Main {
    public static void main(String[] args) {
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "开始搞事?")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null,"正在搞事...");
                }
            }).start();
            Spider.create(new SchoolFlower()).addUrl("http://www.521609.com/daxuexiaohua/list310.html").thread(10).run();
        }
    }
}
