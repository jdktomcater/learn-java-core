package com.jdktomcat.pack.file;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] datas = line.split("\\s+");
            Long id = Long.parseLong(datas[0]);
            String orderId = datas[1];
            String merchantOrderId = datas[2];
            Integer merchantId = Integer.parseInt(datas[3]);
            Integer modificationType = Integer.parseInt(datas[4]);
            BigDecimal preBalance = new BigDecimal(datas[5]);
            BigDecimal postBalance = new BigDecimal(datas[6]);
            BigDecimal preAvailableBalance = new BigDecimal(datas[7]);
            BigDecimal postAvailableBalance = new BigDecimal(datas[8]);
            BigDecimal preFrozenBalance = new BigDecimal(datas[9]);
            BigDecimal postFrozenBalance = new BigDecimal(datas[10]);
            String remark = datas[11];
            String createAt = datas[12];
            String updateAt = datas[13];
            records.add(new Record(id, orderId, merchantOrderId, merchantId, modificationType, preBalance, postBalance, preAvailableBalance, postAvailableBalance, preFrozenBalance, postFrozenBalance, remark, createAt, updateAt));
        }
        return records;
    }

    public static Set<String> checkMissOrder(List<Record> records) {
        Set<String> orderIds = new HashSet<>();
        for (int i = records.size() - 1; i >= 0; i--) {
            Record record = records.get(i);
            // 下单
            if (record.getModificationType() == 10) {
                orderIds.add(record.getOrderId());
            }
            // 结算
            if (record.getModificationType() == 11 || record.getModificationType() == 12) {
                orderIds.remove(record.getOrderId());
            }
        }
        return orderIds;
    }

    public static Set<String> checkAsyncOrder(List<Record> records) {
        Set<String> orderIds = new HashSet<>();
        BigDecimal preBalance = BigDecimal.ZERO;
        for (int i = records.size() - 1; i >= 0; i--) {
            Record record = records.get(i);
            if(record.getModificationType() != 10) {
                continue;
            }
            if(record.getPreAvailableBalance().compareTo(preBalance) != 0) {
                preBalance = record.getPreAvailableBalance();
            }else{
                orderIds.add(record.getOrderId());
            }
        }
        return orderIds;
    }

    public static void writeResult(Set<String> orderIds) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("order_id_except_1.txt"));
        orderIds.forEach(printWriter::println);
        printWriter.flush();
        printWriter.close();
    }


    /**
     * 主函数入口
     *
     * @param args 参数
     */
    public static void main(String[] args) throws IOException, ParseException {
        String filePath = "C:\\timmy\\workspace\\learn-java-core\\txt\\records.txt";
        List<Record> records = readData(filePath);
        Set<String> orderIds = checkAsyncOrder(records);
        writeResult(orderIds);
    }
}
