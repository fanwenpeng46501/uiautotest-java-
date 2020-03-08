package pers.fan.autotest.common;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNG;
import pers.fan.autotest.apppage.HupuPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 樊文鹏 on 2020/3/6.
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    private AndroidDriver driver;

//    打开APP
    public void openapp() throws IOException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage",new Config().read("appPackage"));
        desiredCapabilities.setCapability("appActivity",new Config().read("appActivity"));
        desiredCapabilities.setCapability("platformName",new Config().read("platformName"));
        desiredCapabilities.setCapability("deviceName",new Config().read("deviceName"));
        desiredCapabilities.setCapability("platformVersion",new Config().read("platformVersion"));
        desiredCapabilities.setCapability("udid",new Config().read("udid"));
        desiredCapabilities.setCapability("unicodeKeyboard",true);
        desiredCapabilities.setCapability("resetKeyboard",true);
        desiredCapabilities.setCapability("noReset",true);

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
    }


    //    寻找元素
    public WebElement element(By by){
        return driver.findElement(by);
    }

    //   寻找元素组
    public WebElement elements(By by){
        return (WebElement) driver.findElements(by);
    }

    //    清除内容
    public void clear(By by){
        eleWait(by);
        element(by).clear();
    }

    //    输入文字
    public void sendKey(By by,String s){
        eleWait(by);
        element(by).sendKeys(s);
    }

    //    点击
    public void cli(By by){
        eleWait(by);
        element(by).click();
    }

    //    后退
    public void back(By by){
        driver.navigate().back();
    }

    //    前进
    public void forword(By by){
        driver.navigate().forward();
    }

    //    刷新
    public void f5(By by){
        driver.navigate().refresh();
    }

    //    获取元素的文字
    public String getEleText(By by){
        return element(by).getText();
    }

    //    显式等待
    public void eleWait(By by){
        WebElement element = (new WebDriverWait(driver,5))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //    隐式等待
    public void impWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //    选择下拉框的值
    public void selectValue(By by,String value){
        Select select=new Select(element(by));
        select.selectByValue(value);
    }

//    上滑屏幕
    public void slideUP() {
        int x = driver.manage().window().getSize().width;
        int y = driver.manage().window().getSize().height;
//        driver.swipe(x / 2, y / 3 * 2, x / 2, y / 3 * 1, 1000);
        TouchAction action1=new TouchAction(driver).press(PointOption.point(x/2, y/3*2)).moveTo(PointOption.point(x/2, y/3*1)).release();
        action1.perform();
    }


//     下滑屏幕
    public void slideDown() {
        int x = driver.manage().window().getSize().width;
        int y = driver.manage().window().getSize().height;
//        driver.swipe(x / 2, y / 3 * 1, x / 2, y / 3 * 2, 1000);

        TouchAction action1=new TouchAction(driver).press(PointOption.point(x/2, y/3*1)).moveTo(PointOption.point(x/2, y/3*2)).release();
        action1.perform();
    }


//    左滑屏幕
    public void slideLeft() {
        int x = driver.manage().window().getSize().width;
        int y = driver.manage().window().getSize().height;
        TouchAction action1=new TouchAction(driver).press(PointOption.point(x/6*5, y/2)).moveTo(PointOption.point(x/6*1, y/2)).release();
        action1.perform();
//        driver.swipe(x / 6 * 5, y / 2, x / 6 * 1, y / 2, 1000);
    }


//     右滑屏幕
    public void slideRight() {
        int x = driver.manage().window().getSize().width;
        int y = driver.manage().window().getSize().height;
//        driver.swipe(x / 4 * 1, y / 2, x / 4 * 3, y / 2, 1000);
        TouchAction action1=new TouchAction(driver).press(PointOption.point(x/4*1, y/2)).moveTo(PointOption.point(x/4*3, y/2)).release();
        action1.perform();
    }

    /**
     * 手势解锁九宫格
     * 0 1 2 3 4 5 6 7 8
     */
    public void swipeToUnlock(WebElement lockImageView, int[] path) {
        TouchAction touchAction = new TouchAction(driver);
        List<WebElement> lockItems = lockImageView.findElements(By.className("android.view.View"));
        for (int i = 0; i < path.length; i++) {
            if (i == 0) {
                touchAction.press((PointOption) lockItems.get(path[i])).moveTo((PointOption) lockItems.get(path[i]));
            } else {
                touchAction.moveTo((PointOption) lockItems.get(path[i]));
            }
        }
        touchAction.release();
        touchAction.perform();
    }

    //安装APP
    public void install(String appPath){
        driver.installApp(appPath);
    }

    //卸载APP
    public void remove(String bundleld){
        driver.removeApp(bundleld);
    }

    //启动APP
    public void launch(){
        driver.launchApp();
    }

    //判断APP是否安装
    public boolean isAppInstall(String bundleld){
        return driver.isAppInstalled(bundleld);
    }

    //切换上下文
    public void switchContext(String name){
        driver.context(name);
    }

    //重置APP
    public void reset(){
        driver.resetApp();
    }

    //得到当前的Activity
    public void getCurrActivity(){
        driver.currentActivity();
    }


}
