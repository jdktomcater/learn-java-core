package com.jdktomcat.pack;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Todo {

    INSTANCE;

    static ConcurrentHashMap<Object, String> dataMap = new ConcurrentHashMap<>();

    public void exe(Object key, String value)  {
        if (dataMap.containsKey(key)) {
            try{
                INSTANCE.wait();
                // 以下大括号内代码不能改动
                {
                    try {
                        Thread.sleep(1000);
                        System.out.println(key + ":" + value + ":" + (System.currentTimeMillis() / 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                dataMap.remove(key);
                INSTANCE.notify();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        } else {
            dataMap.put(key, value);
            // 以下大括号内代码不能改动
            {
                try {
                    Thread.sleep(1000);
                    System.out.println(key + ":" + value + ":" + (System.currentTimeMillis() / 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dataMap.remove(key);
        }
    }
}


/**
 * 不能改动此Main类和Builder类
 */
public class Main extends Thread {

    private String key;
    private String value;

    private Main(String key1, String key2, String value) {
        this.key = key1 + key2;
        this.value = value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static void main(String[] args) {

//        System.out.println("Ready Go," + (System.currentTimeMillis() / 1000));
//        builder().key1("YY").key2("").value("Video").build().start();
//        builder().key1("YY").key2("").value("Audio").build().start();
//        builder().key1("YY").key2("").value("EC").build().start();
//        builder().key1("YY").key2("").value("TheOne").build().start();
//        builder().key1("Duowan").key2("").value("Game").build().start();
//        builder().key1("Huya").key2("").value("Video").build().start();

//        String shopId = "认定的2024.09月";
//        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)");
//        Matcher matcher = pattern.matcher(shopId);
//        StringBuilder builder=new StringBuilder();
//        //当符合正则表达式定义的条件时
//        while (matcher.find()) {
//            builder.append(matcher.group()).append(",");
//        }
//        builder.deleteCharAt(builder.length()-1);
//        System.out.println(builder);

        String message = "【稠州银行】您尾号2608的银联卡于01月23日19:20超网来账收入RMB300.00,余额RMB2095.29,汇款行:中国农业银行,汇款人:刘彬.;";
        System.out.println(getTradeName(message));
    }
    static BigDecimal getAmount(String content){
        content = content.replaceAll(" ","").replaceAll("，",",");
        if( content.contains("RMB")){
            return new BigDecimal(content.substring(content.indexOf("RMB") + 3, content.indexOf(",") ).replace(",", ""));
        } else if (content.contains("转账减少")) {
            return new BigDecimal(content.substring(content.indexOf("转账减少") + 4, content.indexOf("元")));
        }

        return new BigDecimal(0);
    }
    static Boolean getDepositTransType(String content){
        if(content.contains("收入")){return true;}
        return false;
    }
    static Boolean getWithdrawTransType(String content) {
        if(content.contains("支出")){
            return true;
        }
        return false;
    }
    static String getTradeNumber(String content) {
        if (content.contains("您尾号")) {
            return content.substring(content.indexOf("您尾号") + 3, content.indexOf("的银联卡"));
        }
        return "";
    }
    static Boolean getBankType(String content) {
        if (content.contains("稠州银行")) {return true;}
        return false;
    }
    static String getHour(String content) {

        return "";
    }
    static String getMinute(String content) {

        return "";
    }
    static BigDecimal getBalance(String content){

        if(content.contains("余额为RMB")){
            return new BigDecimal(content.substring(content.indexOf("余额为RMB") +6, content.lastIndexOf(".")).replace(",", ""));
        }
        if(content.contains("余额RMB")){
            return new BigDecimal(content.substring(content.indexOf("余额RMB") +5, content.lastIndexOf(",汇款行")).replace(",", ""));
        }
        return new BigDecimal(-1);
    }
    static String getTradeName(String content) {
        String s="";
        if(content.contains("款人")){
            content = content.substring(content.indexOf("款人")).replace(" ","");
            s=content.substring(content.indexOf("款人：") +4,content.lastIndexOf("."));
            return s;
        }
        return "";
    }



    @Override
    public void run() {
        Todo.INSTANCE.exe(key, value);
    }

    public static class Builder {
        private String key1;
        private String key2;
        private String value;

        private Builder() {
        }

        public Builder key1(String key1) {
            this.key1 = key1;
            return this;
        }

        public Builder key2(String key2) {
            this.key2 = key2;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Main build() {
            return new Main(key1, key2, value);
        }
    }
}