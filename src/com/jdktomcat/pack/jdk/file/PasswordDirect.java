package com.jdktomcat.pack.jdk.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 类概述：密码本
 *
 * @author tangqi
 * @date 2022-04-12
 */
public class PasswordDirect {

    /**
     * 基础字符数组
     */
    private static final char[] CHAR_TARGET = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 生成密码
     *
     * @param filePath 目标文件
     * @throws FileNotFoundException 文件异常
     */
    private static void generate(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
//            imeiSet.add(scanner.next().trim());
        }
    }

    public static void main(String[] args) throws IOException {
        String passFile = "/Users/tangqi/Desktop/pass.txt";
        PasswordDirect.generate(passFile);
    }

}
