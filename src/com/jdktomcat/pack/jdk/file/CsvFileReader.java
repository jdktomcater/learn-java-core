package com.jdktomcat.pack.jdk.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述 极速相关服务组件
 * @date 2024-03-2024/3/22 上午 10:37
 */
public class CsvFileReader {


    public static class Record {

        Long id;

        String orderId;

        BigDecimal pre;

        BigDecimal post;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public BigDecimal getPre() {
            return pre;
        }

        public void setPre(BigDecimal pre) {
            this.pre = pre;
        }

        public BigDecimal getPost() {
            return post;
        }

        public void setPost(BigDecimal post) {
            this.post = post;
        }
    }

    private static Record convert(String content) {
        String[] params = content.split(",");
        Record record = new Record();
        record.setId(Long.parseLong(params[0]));
        record.setOrderId(params[1]);
        record.setPre(new BigDecimal(params[9]));
        record.setPost(new BigDecimal(params[10]));
        return record;
    }


    private static List<String> readContent(String filePath) throws FileNotFoundException {
        List<String> contentList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath), "UTF-8");
        //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
        while (scanner.hasNext()) {
            contentList.add(scanner.next());
        }
        return contentList;
    }

    private static List<Record> convert(List<String> contentList) {
        List<Record> recordList = new ArrayList<>();
        for (String s : contentList) {
            recordList.add(convert(s));
        }
        return recordList;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\ZF-Timmy\\Desktop\\data.txt";
        List<String> contentList = readContent(filePath);
        List<Record> recordList = convert(contentList);
        BigDecimal post = recordList.get(0).getPost();
        for(int i=1;i<recordList.size();i++){
            Record record = recordList.get(i);
            if(post.compareTo(record.getPre())!=0){
                System.out.println(record.getOrderId());
            }
            post = record.getPost();
        }
    }
}


