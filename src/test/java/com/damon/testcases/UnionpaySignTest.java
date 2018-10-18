package com.damon.testcases;

import com.damon.base.BaseDriver;
import com.damon.business.UnionpaySign;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnionpaySignTest {

    private BaseDriver driver;

    @BeforeClass
    public void getDriver(){
        this.driver = BaseCase.DRIVER;
    }

    @Test
    public void signSuccessTest(){
        String result = UnionpaySign.sign(driver);
        Assert.assertEquals("今日已签到",result);
    }
}
