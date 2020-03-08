package pers.fan.autotest.webpage;

import org.apache.log4j.Logger;
import pers.fan.autotest.apppage.HupuPage;
import pers.fan.autotest.common.Web;
import org.openqa.selenium.By;

/**
 * Created by 樊文鹏 on 2020/3/6.
 */
public class BaiduPage {
    private static final Logger logger = Logger.getLogger(BaiduPage.class);
    private  Web web;
    public BaiduPage(String brower){
        Web web=new Web(brower);
        this.web=web;
    }

    //搜索框的元素
    private By ele01=By.id("kw");

    //“百度一下”按钮的元素
    private By ele02=By.id("su");

    public void  seach(){
        web.clear(ele01);
        web.sendkey(ele02,"NBA");

    }
}
