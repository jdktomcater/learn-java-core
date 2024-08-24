package com.jdktomcat.pack.jdk.file;

import java.io.*;
import java.util.*;

/**
 * 类描述：文件扫描
 *
 * @author 汤旗
 * @date 2019-11-05 16:26
 */
public class FileScanner {
    private static Map<String, String> getFileSet(String filePath) throws FileNotFoundException {
        Map<String, String> dataMap = new HashMap<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            String line = scanner.next().trim();
            String[] params = line.split(",");
            if (params.length == 2) {
                dataMap.put(params[0].trim(), params[1].trim());
            }
        }
        return dataMap;
    }

    public static void main(String[] args) throws IOException {
        String sourceFile = "/Users/tangqi/Desktop/source.txt";
        String theirDataFile = "/Users/tangqi/Desktop/curl.txt";
        String cmd = "curl --location --request POST 'http://127.0.0.1:7001/mp/shop/system/sendMetaProducerMessage' \\\n" + "--header 'Content-Type: application/x-www-form-urlencoded' \\\n" + "--data-urlencode 'topic=AMAP-MP-SHOP-CREATE-TOPIC' \\\n" + "--data-urlencode 'tag=' \\\n" + "--data-urlencode 'key=' \\\n" + "--data-urlencode 'body={\"merchantId\":\"1088013104187694\",\"cpid\":\"%s\",\"source\":\"wuliangye_api\",\"shopId\":\"%s\"}'";
        Map<String, String> dataMap = getFileSet(sourceFile);
        PrintWriter printWriter = new PrintWriter(theirDataFile);
        dataMap.forEach((key, value) -> {
            printWriter.println(String.format(cmd, key, value));
            printWriter.flush();
        });
    }
}
