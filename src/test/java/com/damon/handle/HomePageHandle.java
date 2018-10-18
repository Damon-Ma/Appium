package com.damon.handle;

import com.damon.base.BaseDriver;
import com.damon.page.HomePage;
import com.damon.util.TestLog;

public class HomePageHandle {

    //判断签到入口是否存在
    public static boolean signIsEnabled(BaseDriver driver){
        return HomePage.sign(driver).isEnabled();
    }
    //点击签到入口
    public static void signClick(BaseDriver driver){
        HomePage.sign(driver).click();
    }

    //点击签到
    public static void signBtClick(BaseDriver driver){
        HomePage.signBt(driver).click();
    }

    //获取签到文字
    public static String getSignBtText(BaseDriver driver){
        return HomePage.signBt(driver).getText();
    }

    //点击空白处
    public static void blankClick(BaseDriver driver){
        driver.findElement("cancel");
    }
}
