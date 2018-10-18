package com.damon.testcases;

import com.damon.base.BaseDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BaseCase {

    public static BaseDriver DRIVER;

    @BeforeTest
    public void initDriver(){
        DRIVER = new BaseDriver();
        DRIVER.sleep(5000);

        //创建输出文件夹
        String OUTPUT_FOLDER = "test-output/";
        File reportDir= new File(OUTPUT_FOLDER);
        if(!reportDir.exists()&& !reportDir.isDirectory()){
            reportDir.mkdir();
        }


    }
    @AfterTest
    public void quit(){
        DRIVER.quit();
    }

}
