package com.damon.util;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 截图方法，
 * 参考：https://www.cnblogs.com/Jourly/p/7444693.html
 */
public class TakeScreenshot {
    private AndroidDriver driver;

    public TakeScreenshot(AndroidDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShot(String classname, String methodname) {
        // 获取截图file
        File file = driver.getScreenshotAs(OutputType.FILE);
        try {
            // 将图片移动到指定位置
            FileUtils.moveFile(file, new File(getFilePath(classname, methodname)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getFilePath(String classname, String methodname) {
        // 创建储存图片的路径，不存在则创建
        File dir = new File("test-output/screenshot");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateStr = dateFormat.format(new Date());
        // 获取新的文件名，包含时间，类名，方法名
        String fileName = dateStr + "_" + classname + "_" + methodname + ".jpg";
        // 获取文件路径
        String filePath = dir.getAbsolutePath() + "/" + fileName;
        TestLog.logger.info("截图："+filePath);
        return filePath;
    }
}
