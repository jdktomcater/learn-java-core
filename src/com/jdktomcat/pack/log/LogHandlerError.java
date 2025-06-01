package com.jdktomcat.pack.log;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述 极速相关服务组件
 * @date 2024-02-2024/2/28 下午 6:44
 */
public class LogHandlerError {
    public static void main(String[] args) throws IOException {
        String http = "http://";
        String https = "https://";
        Scanner scanner = new Scanner(new File("C:\\timmy\\workspace\\learn-java-core\\txt\\log.txt"));
        PrintWriter printWriter = new PrintWriter("C:\\timmy\\workspace\\learn-java-core\\txt\\log-error.txt");

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if(line.contains(http) || line.contains(https)){
                printWriter.println(line);
                printWriter.flush();
            }
        }
        printWriter.close();
    }
}
