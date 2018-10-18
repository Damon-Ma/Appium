package com.damon.util;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetLogcat {
    private AndroidDriver driver;

    public GetLogcat(AndroidDriver driver) {
        this.driver = driver;
    }

    public void getLogcat(String classname, String methodname) {
        //用cmd抓取logcat
        String cmd = "cmd /c\" adb shell logcat -d -v time > " +getFilePath(classname,methodname);
        try {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilePath(String classname, String methodname) {
        // 创建储存图片的路径，不存在则创建
        File dir = new File("test-output/logcat");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateStr = dateFormat.format(new Date());
        // 获取新的文件名，包含时间，类名，方法名
        String fileName = dateStr + "_" + classname + "_" + methodname + ".txt";
        // 获取文件路径
        String filePath = dir.getAbsolutePath() + "/" + fileName;
        TestLog.logger.info("日志："+filePath);
        return filePath;
    }
}
