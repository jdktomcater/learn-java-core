package com.jdktomcat.pack.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 记录处理
 */
public class RecordsHandler {


    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return 记录列表
     */
    private static List<Record> readData(String filePath) throws FileNotFoundException {
        List<Record> records = new ArrayList<>(100000);
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] datas = line.split("\\s+");
            records.add(new Record(new BigDecimal(datas[0].trim()), new BigDecimal(datas[1].trim())));
        }
        return records;
    }

    /**
     * 检查数据
     *
     * @param records 数据
     */
    private static void checkData(List<Record> records) throws FileNotFoundException {
        BigDecimal pre = records.get(0).getPre();
        PrintWriter printWriter = new PrintWriter("out.txt");
        for (int i = 1; i < records.size(); i++) {
            if (pre.compareTo(records.get(i).getPost()) != 0) {
                printWriter.println("行：" + i + " 数据异常：" + records.get(i).toString());
            }
            pre = records.get(i).getPre();
        }
        printWriter.flush();
    }

    /**
     * 主函数入口
     *
     * @param args 参数
     */
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\timmy\\workspace\\learn-java-core\\txt\\data.txt";
        RecordsHandler.checkData(readData(filePath));
    }
}
