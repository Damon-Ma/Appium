package com.damon.base;

import com.damon.util.ReadProperties;
import com.damon.util.TestLog;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BaseDriver {
    public AndroidDriver driver;

    /**
     * 返回driver对象
     * @return
     */
    public AndroidDriver getDriver() {
        return driver;
    }

    /**
     * 初始化driver，将配置全部写在properties文件中
     * 默认不重置app
     */
    public BaseDriver(){
        TestLog.logger.info("---------------Beginning of the test---------------");
        DesiredCapabilities cap = new DesiredCapabilities();
        List<String> keys = ReadConfig.getConfigKeys();
        for (String key : keys){
            String value = ReadConfig.getConfig(key);
            if (!value.matches(" ")&& value.length()>0){
                TestLog.logger.info(key+":"+ReadConfig.getConfig(key));
                cap.setCapability(key,ReadConfig.getConfig(key));
            }
        }
        cap.setCapability("noReset",true);

        try {
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * quit
     */
    public void quit(){
        TestLog.logger.info("---------------End Of Test---------------");
        driver.quit();
    }

    /**
     *
     * @param key element的key值
     * @return  WebElement对象
     */
    public WebElement findElement(String key){
        ResourceBundle bundle = ReadProperties.getprop("element");
        String value = bundle.getString(key);
        String[] ByElement = value.split(">");

        if (ByElement.length==2){
            String byName = ByElement[0];
            String elementName = ByElement[1];
            try{
                if ("id".equals(byName)) {
                    TestLog.logger.info("定位方法：id --> 定位元素："+elementName);
                    return driver.findElementById(elementName);
                }else if ("text".equals(byName)){
                    TestLog.logger.info("定位方法：文本 --> 定位元素："+elementName);
                    String path = "//android.widget.TextView[contains(@text,\""+elementName+"\")]";
                    return driver.findElementByXPath(path);
                }else if ("class".equals(byName)){
                    TestLog.logger.info("定位方法：class --> 定位元素："+elementName);
                    return driver.findElementByClassName(elementName);
                }else if ("xpath".equals(byName)){
                    TestLog.logger.info("定位方法：xpath --> 定位元素："+elementName);
                    return driver.findElementByXPath(elementName);
                }else if ("coordinate".equals(byName)){
                    String x = elementName.split(",")[0];
                    String y = elementName.split(",")[1];

                    Integer xx = new Integer(x);
                    Integer yy = new Integer(y);

                    tap(xx,yy);

                }
            }catch (NoSuchElementException e){
                TestLog.logger.error("element未找到："+elementName+",定位方法："+byName);
                e.printStackTrace();
            }

        }

        return null;
    }

    /**
     * sleep
     * @param millis
     */
    public void sleep(long millis){
        try {
            TestLog.logger.info("等待："+millis+"ms");
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 点击坐标
     */
    public void tap(int x ,int y) {
        TestLog.logger.info("点击坐标----> x:"+x+"  y:"+y);
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x,y)).perform();
    }
}
