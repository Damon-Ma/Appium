package com.damon.business;

import com.damon.base.BaseDriver;
import com.damon.handle.HomePageHandle;

public class UnionpaySign {
    public static String sign(BaseDriver driver){
        HomePageHandle.signClick(driver);
        driver.sleep(2000);
        HomePageHandle.signBtClick(driver);
        driver.sleep(2000);
        HomePageHandle.blankClick(driver);
        driver.sleep(2000);
        String signResult = HomePageHandle.getSignBtText(driver);
        return signResult;

    }
}
