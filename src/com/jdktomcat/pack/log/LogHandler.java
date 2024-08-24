package com.jdktomcat.pack.log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述 极速相关服务组件
 * @date 2024-02-2024/2/28 下午 6:16
 */
public class LogHandler {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        int[] arr = new int[100001];
        String pattern = ".*username\":\"timmy-dev-(\\d+).*";
        Pattern r = Pattern.compile(pattern);
        Matcher m;
        int i;
        int count = 1;
        reader = new BufferedReader(new FileReader("D:\\download\\firefox\\TyPayJV2MQConsumer.log"));
        String line = reader.readLine();
        while (line != null) {
            m = r.matcher(line);
            if (m.find()) {
                i = Integer.parseInt(m.group(1));
                arr[i] = i;
                System.out.println(line);
            }
            line = reader.readLine();
        }
        reader.close();
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != 0) {
                count++;
            } else {
                System.out.println("数据丢失：timmy-dev-" + j);
            }
        }
        System.out.println("接受到到日志数据量：" + count);
    }

}
