package pers.fan.autotest.testcase;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pers.fan.autotest.apppage.HupuPage;

/**
 * Created by 樊文鹏 on 2020/3/6.
 */
public class TestHupu {
    HupuPage hupuPage=new HupuPage();

    @Test(groups = "appg01")
    public void test01(){
        hupuPage.appseach();
    }

    @BeforeGroups(groups = "appg01")
    public void beforegroup(){

    }

    @AfterGroups(groups = "appg01")
    public void aftergroup(){

    }


}
