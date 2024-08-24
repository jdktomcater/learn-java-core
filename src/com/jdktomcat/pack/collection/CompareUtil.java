package com.jdktomcat.pack.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 类描述：对比工具类
 *
 * @author 11072131
 * @date 2020-02-2020/2/29 10:33
 */
public class CompareUtil {

    private static Set<String> getContentSet(String filePath) throws FileNotFoundException {
        Set<String> contentSet = new HashSet<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            contentSet.add(scanner.next().trim());
        }
        scanner.close();
        return contentSet;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> billAllSet = getContentSet("C:\\Users\\Administrator\\Desktop\\data\\bill-all.txt");
        Set<String> bigDataAllSet = getContentSet("C:\\Users\\Administrator\\Desktop\\data\\bigdata-all.txt");
        Set<String> billSet = getContentSet("C:\\Users\\Administrator\\Desktop\\data\\bill.txt");
        Set<String> bigDataSet = getContentSet("C:\\Users\\Administrator\\Desktop\\data\\bigdata.txt");
        Set<String> result = new HashSet<>();
        result.clear();
        result.addAll(billAllSet);
        result.removeAll(bigDataAllSet);
        System.out.println("计费总数与大数据总数差异（条数：" + result.size() + "）：");
        result.clear();
        result.addAll(billSet);
        result.retainAll(bigDataSet);
        System.out.println("计费与大数据交集（条数：" + result.size() + "）：");
        for (String imei : result) {
            System.out.println(imei);
        }
        result.clear();
        result.addAll(billSet);
        result.removeAll(bigDataSet);
        System.out.println("计费中有大数据没有（条数：" + result.size() + "）：");
        for (String imei : result) {
            System.out.println(imei);
        }
        result.clear();
        result.addAll(bigDataSet);
        result.removeAll(billSet);
        System.out.println("大数据中有计费没有（条数：" + result.size() + "）：");
        for (String imei : result) {
            System.out.println(imei);
        }
    }
}
