package com.jdktomcat.pack;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述：
 * @date 2024/1/17
 */
public class DecodeUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {


        String a = "static char ch;\n" +
                "    static short sh;\n" +
                "    static String str;\n" +
                "    static String b ;";

        // 使用基本编码
        String base64encodedString = Base64.getEncoder().encodeToString(a.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

        base64encodedString = "VGhpcmRXaXRoZHJhd09yZGVyRFRPKHRoaXJkTWVyY2hhbnRLZXk9N290MHltMGV4cXkxNHZvNHx3eTUxb2NucnAybzlmeGo4LCB0aGlyZE1lcmNoYW50UHVibGljS2V5cz0yfDEsIGNoYW5uZWxNZXJjaGFudElEPTJXOFpQLCBwYXl1cmw9aHR0cDovL3dhbGxldC1hcGktbGFuLmVicGF5Lm9yZywgbm90aWZ5dXJsPS90aGlyZHBheS9kY3BheS93aXRoZHJhd05vdGljZSwgd2l0aGRyYXdVcmw9MSwgYmFua1R5cGVOYW1lPW51bGwsIGJhbmtuYW1lPeWRqOaMr+WHoSwgYmFua251bT1lYmRmZGQ3NGZlNmZmZTg2YTA4NTFiZDljOGUwMGI2MDJkLCBhbW91bnQ9MjAwLjAwLCByZW1hcms9bnVsbCwgYmFua0NvZGU9RUJwYXksIHJlYWxNZXJjaGFudElkPTIwMDA1OSwgc3VwcGxpZXJCcmFuY2hJRD0xMywgYmFua0FkZHJlc3M9LCBvcmRlcmlkPUgyMDAwNTk0MjQwMTE3MTUwOTAzNTEzNjY4ZTAwLCB1c2VySUQ9NDc3MjAxNCwgbWQ1T3JkZXJJZD04MDRkZDJiMjI5ZTA0ZjcyOThhZGJiODk4NWYwMzZmNywgdXNlcklQPTYuMTY3LjIzLjEzNSwgcGxhdGZvcm1Ob3RpZnlVcmw9aHR0cDovL2Zhc3RwYXljYWxsYmFjay5jYWxsbmV3YmFjay5jb20vZmRjYWxsYmFjay92MS9XaXRoZHJhdy9UeVBheUNhbGxiYWNrLCBvcmRlclN0YXR1cz0wLCBjYWxsYmFja1VybD1odHRwOi8vY2FsbGJhY2suamlhbnR4Y2FsbGJhY2tiYy5jb20sIHRoaXJkT3JkZXJJZD1udWxsLCB1c2VyTGV2ZWw9NiwgdXNlckNyZWRpdExldmVsPTZfNSwgcGF5VHlwZT0yMTgyLCBtZW1iZXJBY2NvdW50PXp6ZjA0MjQsIHByb3RvY29sPSwgY2FsbFN0YXR1cz0xLCBjYWxsVG9rZW49MTcwNTQ3NTM0MzUzODJXOFpQMjc1NjkzLCB0aGlyZE1lcmNoYW50SWQ9MzY5LCBhbW91bnRUeXBlPUNOWSwgaGFzaFRyYW5zSUQ9LCB2aXJ0dWFsUGF5QW1vdW50PTAuMDAwMCwgbWVyY2hhbnRPcmRlcklkPUVCVDAyMjAyNDAxMTcxNDM2MDRXdUd0KQ==";
        // 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("paytype", "1d");
        String A = dataMap.get("paytype").toString().toUpperCase();

        System.out.println("原始字符串: "+ A + new String(base64decodedBytes , StandardCharsets.UTF_8));


    }
    public  static String  pup2(String b){
        String a =b;
        System.out.println(a);
        a = "1";
        b = "13";
        System.out.println(a);
        System.out.println(b);
        return b;
    }

}
