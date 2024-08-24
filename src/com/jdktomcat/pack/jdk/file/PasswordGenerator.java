package com.jdktomcat.pack.jdk.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PasswordGenerator {

    /**
     * 密码字符
     */
    public static final char[] TARGETS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 后缀
     */
    public static final String PREFIX = "8Sf5Ic";

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("C:\\Users\\jdktomcat\\Desktop\\pass.txt");
        for (int index1 = 0; index1 < TARGETS.length; index1++) {
            for (int index2 = 0; index2 < TARGETS.length; index2++) {
                for (int index3 = 0; index3 < TARGETS.length; index3++) {
                    for (int index4 = 0; index4 < TARGETS.length; index4++) {
                        for (int index5 = 0; index5 < TARGETS.length; index5++) {
                            for (int index6 = 0; index6 < TARGETS.length; index6++) {
                                String pass = "" + TARGETS[index1] + TARGETS[index2] + TARGETS[index3] + TARGETS[index4] + TARGETS[index5] + TARGETS[index6] + PREFIX;
                                System.out.println(pass);
                                printWriter.println(pass);
                                printWriter.flush();
                            }
                        }
                    }
                }
            }
        }
    }
}


