package com.damon.util;


import java.util.Locale;
import java.util.ResourceBundle;


public class ReadProperties {

	/**
	 * 根据文件名称、获取对应Bundle
	 * 默认在resources目录下寻找properties文件
	 * 只需传相对路径和文件名，不需要扩展名
	 */
	public static ResourceBundle getprop(String filename){
       return ResourceBundle.getBundle(filename,Locale.CHINA);
	}
}