package pers.fan.autotest.common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by 樊文鹏 on 2020/3/8.
 */
public class Com {
    private static final Logger logger = Logger.getLogger(Com.class);

    //断言，判断相等
    public void assetEqual(Object actual,Object exp){
        if(actual.equals(exp)){
            logger.info("断言成功");
        }else {
            logger.info("断言失败");
        }
    }

    //截屏
    public void get_screen(Object driver) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); //转换时间格式
        String time = dateFormat.format(Calendar.getInstance().getTime()); //获取当前时间
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //执行屏幕截取
        String path=System.getProperty("user.dir")+"/src/main/java/pers/fan/autotest/img";
        FileUtils.copyFile(srcFile, new File(path, time + ".png")); //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
    }
}
