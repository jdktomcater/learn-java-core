package com.jdktomcat.pack.dsa.algorithm.sort;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;

/**
 * 类描述：随机数据文件写
 *
 * @author 11072131
 * @date 2020-04-2020/4/3 17:28
 */
public class RandomNumberFile {

    public static void write() throws IOException {
        String filePath = "C:\\Users\\Administrator\\Desktop\\number.txt";
        Random random = new Random();
        PrintWriter writer = new PrintWriter(filePath);
        for (int i = 0; i < 100000; i++) {
            writer.println(random.nextInt(Integer.MAX_VALUE));
        }
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        RandomNumberFile.write();
    }
}
