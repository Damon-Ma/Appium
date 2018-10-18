package com.damon.page;

import com.damon.base.BaseDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public static WebElement sign(BaseDriver driver){
        return driver.findElement("sign");
    }

    //签到按钮
    public static WebElement signBt(BaseDriver driver){
        return driver.findElement("signBt");
    }
}
