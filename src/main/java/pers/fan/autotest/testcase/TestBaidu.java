package pers.fan.autotest.testcase;

import pers.fan.autotest.common.Web;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import  org.testng.annotations.Test;
import pers.fan.autotest.webpage.BaiduPage;


/**
 * Created by 樊文鹏 on 2020/3/6.
 */
public class TestBaidu {
    private BaiduPage baiduPage=new BaiduPage("chrome");

    @BeforeGroups(groups = "g1")
    public void before(){

    }
    @Test(groups = "g1")
    public void test001(){
        baiduPage.seach();

    }

    @AfterGroups(groups = "g1")
    public void after(){

    }
}
