package com.lga.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

public class Tools {


    /**
     * 驼峰转下划线
     *
     * @param str
     * @return
     */
    public static String camelToUnderline(String strJson) {

        final JSONObject newJsonObject = new JSONObject();
        final JSONObject jsonObject = JSONObject.parseObject(strJson);
        final Set<String> strings = jsonObject.keySet();

        for (String str : strings) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append("_");
                    sb.append(Character.toLowerCase(c));
                }else{
                    sb.append(c);
                }
            }
            newJsonObject.put(String.valueOf(sb), jsonObject.get(str));
        }


        return newJsonObject.toJSONString();
    }

    public static void main(String[] args) {

        String str = "{\"extraInfo\":\"{\\\"origTradeNO\\\":\\\"MM00005579\\\",\\\"storeId\\\":\\\"7614\\\"}\",\"orderCurrency\":\"CNY\",\"outTradeNo\":\"MM000055790176141001\",\"payType\":\"ecard\",\"rectification\":false,\"refundAmount\":40,\"requestNo\":\"HA0002286761476141001\"}";
        System.out.println(camelToUnderline(str));
    }






}
