package com.damon.util;

import com.damon.testcases.BaseCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class FailureListener extends TestListenerAdapter {
    /**
     * 重写失败监听方法
     * @param tr
     */
    @Override
    public void onTestFailure(ITestResult tr) {
        // TODO Auto-generated method stub
        super.onTestFailure(tr);
        // 类名为全类名，包含包名
        String classname = tr.getTestClass().getName();
        // 方法名为执行的方法
        String methodname = tr.getMethod().getMethodName();

        // 此处为获取当前的driver，在BaseCase中创建了BaseDriver对象，然后使用BaseDriver获取WebDriver对象
        AndroidDriver driver = BaseCase.DRIVER.getDriver();
        TakeScreenshot shot = new TakeScreenshot(driver);
        GetLogcat logcat = new GetLogcat(driver);
        shot.takeScreenShot(classname, methodname);
        logcat.getLogcat(classname,methodname);
    }
}
