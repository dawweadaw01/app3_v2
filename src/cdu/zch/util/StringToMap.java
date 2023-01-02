package cdu.zch.util;

import java.util.HashMap;
import java.util.Map;

public class StringToMap {

    /**
     * 将Map字符串转换为Map
     *
     * @param str Map字符串
     * @return Map
     */
    public static Map<Integer,Integer> mapStringToMap(String str){
        str = str.substring(1, str.length()-1);
        String[] strs = str.split(",");
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (String string : strs) {
            String key = string.split("=")[0];
            String value = string.split("=")[1];
            // 去掉头部空格
            int key1 = Integer.parseInt(key.trim());
            int value1 = Integer.parseInt(value.trim());
            map.put(key1, value1);
        }
        return map;
    }

}
