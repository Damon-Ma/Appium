package com.damon.base;

import com.damon.util.ReadProperties;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ReadConfig {
    /**
     * 获取config
     */
    static String getConfig(String configName){
        return ReadProperties.getprop("config").getString(configName);
    }

    /**
     * 获取所有配置key
     */
    static List<String> getConfigKeys() {
        List<String> keys = new ArrayList<String>();
        Enumeration<String> s = ReadProperties.getprop("config").getKeys();
        while (s.hasMoreElements()){
            String key = s.nextElement();
            keys.add(key);
        }
        return keys;
    }

}
