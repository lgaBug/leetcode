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

        String str = "{\n" +
                "    \"account_no\": \"69637C3B-100E-624C-0542-8FB8311F52FA\",\n" +
                "    \"accountType\": \"ecard\",\n" +
                "    \"isRectification\": false,\n" +
                "    \"outTradeNo\": \"2105126271024156990\",\n" +
                "    \"payType\": \"ecard\",\n" +
                "    \"rectification\": false,\n" +
                "    \"refundAmount\": 2213,\n" +
                "    \"requestNo\": \"20210513RR6963012833\"\n" +
                "}";
        System.out.println(camelToUnderline(str));
    }
}
