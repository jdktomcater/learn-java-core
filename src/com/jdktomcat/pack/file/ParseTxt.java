package com.jdktomcat.pack.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ParseTxt {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("C:\\yuhata\\workspace\\github\\jdktomcater\\learn-java-core\\txt\\case.txt"));

        while (sc.hasNextLine()) {
            String content = sc.nextLine();
            if(content.contains("case")){
                int start = content.indexOf("\"");
                int end = content.indexOf("\"", start + 1);
                String tag = content.substring(start+1,end);
                System.out.println(tag);
            }
        }
    }
}
