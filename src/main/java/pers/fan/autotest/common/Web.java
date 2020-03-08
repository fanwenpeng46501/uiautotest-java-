package pers.fan.autotest.common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pers.fan.autotest.apppage.HupuPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by 樊文鹏 on 2020/3/6.
 */
public class Web {
    private static final Logger logger = Logger.getLogger(App.class);
    private WebDriver driver;

//    判断浏览器，初始化
    public Web(String brower){
        if (brower.equals("chrome")){
            this.driver=new ChromeDriver();

        }
        else if (brower.equals("firefox")){
            this.driver=new FirefoxDriver();
        }
        else if (brower.equals("safari")){
            this.driver=new SafariDriver();

        }
        else {
            System.out.println("请输入正确的浏览器");
        }

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
        elewait(by);
        element(by).clear();
    }

//    输入文字
    public void sendkey(By by,String s){
        elewait(by);
        element(by).sendKeys(s);
    }

//    点击
    public void cli(By by){
        elewait(by);
        element(by).click();
    }

//    打开网址
    public void open(String url){
        driver.get(url);
    }

//    最大化浏览器
    public void maxwindow(){
        driver.manage().window().maximize();
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
    public void refresh(By by){
        driver.navigate().refresh();
    }

//    设置浏览器的大小
    public void set_winsize(Dimension dimension){
        driver.manage().window().setSize(dimension);
    }

//    右击
    public void right_click(By by){
        elewait(by);
        Actions actions=new Actions(driver);
        actions.contextClick(element(by)).perform();

    }

//    移动到某个元素
    public void move_ele(By by){
        elewait(by);
        Actions actions=new Actions(driver);
        actions.moveToElement(element(by)).perform();
    }

//    双击
    public void doubleclik(By by){
        elewait(by);
        Actions actions=new  Actions(driver);
        actions.doubleClick(element(by)).perform();
    }

//    关闭当前网页
    public void close(){
        driver.close();
    }

//    退出浏览器
    public void quit(){
        driver.quit();
    }

//    执行js
    public void js(String s){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(s);
    }

//    获取元素的文字
    public String geteletext(By by){
        return element(by).getText();
    }

//    显式等待
    public void elewait(By by){
        WebElement element = (new WebDriverWait(driver,5))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

//    隐式等待
    public void impwait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    接受弹窗
    public void  accpet_alert(){
        driver.switchTo().alert().accept();
    }

//    取消弹窗
    public void  dismiss_alert(){
        driver.switchTo().alert().dismiss();
    }

//    弹窗输入文字
    public void  sendkey_alert(String s){
        driver.switchTo().alert().sendKeys(s);
    }

//    切换frame
    public void swichframe(By by){
        elewait(by);
        driver.switchTo().frame(element(by));
    }

//    从frame中返回
    public void switch_to_content(){
        driver.switchTo().defaultContent();
    }

//    选择窗口
    public void switch_to_win(){
        Set<String> windows=driver.getWindowHandles();
        for (String win:windows){
            if(!win.equals(driver.getWindowHandle())){
                driver.switchTo().window(win);
            }
        }
    }


//    选择下拉框的值
    public void select_value(By by,String value){
        Select select=new Select(element(by));
        select.selectByValue(value);
    }

//    获取当前的标题
    public String getTitle(){
        return driver.getTitle();
    }

//    获取当前的url
    public String getCurrentUrl(){
        return  driver.getCurrentUrl();
    }

}
