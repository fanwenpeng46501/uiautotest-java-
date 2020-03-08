package pers.fan.autotest.apppage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pers.fan.autotest.common.App;

/**
 * Created by 樊文鹏 on 2020/3/6.
 */
public class HupuPage {
    private static final Logger logger = Logger.getLogger(HupuPage.class);
    private App app;
    private static By SearchBox=By.id("com.hupu.games:id/tv_banner2");
    private static By Input=By.id("com.hupu.games:id/search_input");
    private static By Botton=By.id("com.hupu.games:id/search_btn_cancel");

    public HupuPage(){
        App app=new App();
        this.app=app;
    }

    public void appseach(){
        app.cli(SearchBox);
        app.sendKey(Input,"NBA");
        app.cli(Botton);

    }


}
