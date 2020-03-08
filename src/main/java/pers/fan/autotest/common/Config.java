package pers.fan.autotest.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 樊文鹏 on 2020/3/7.
 */
public class Config {
    public Properties properties;

    public String read(String key) throws IOException {
        properties=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        properties.load(fis);
        String value=properties.getProperty(key);
        return value;
    }
}
