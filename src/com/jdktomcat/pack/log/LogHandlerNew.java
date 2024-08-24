package com.jdktomcat.pack.log;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述 极速相关服务组件
 * @date 2024-02-2024/2/28 下午 6:44
 */
public class LogHandlerNew {
    public static void main(String[] args) throws IOException {
        String pattern = ".*username\":\"timmy-dev-(\\d+).*";
        Scanner scanner = new Scanner("D:\\download\\firefox\\TyPayJV2MQConsumernew.log");
        while(scanner.hasNext(pattern)){
            System.out.println(scanner.next(pattern));
        }
    }
}
