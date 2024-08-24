package com.jdktomcat.pack.jdk.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 将文件扁平化处理
 */
public class FileMoveFromFolder {

    /**
     * 文件便利遍历
     *
     * @param root     根目录
     * @param fileList 文件列表
     */
    private static void findFileList(File root, List<File> fileList) {
        if (fileList == null) {
            fileList = new LinkedList<>();
        }
        if (root.isFile()) {
            return;
        }
        File[] subFiles = root.listFiles();
        for (File subFile : subFiles) {
            if (subFile.isFile()) {
                fileList.add(subFile);
            } else {
                findFileList(subFile, fileList);
            }
        }
    }

    /**
     * 将文件移动目录下
     *
     * @param file     文件
     * @param rootPath 目录
     */
    private static void moveFile(File file, String rootPath) {
        String fileName = file.getName();
        File targetFile = new File(rootPath + File.separator + fileName);
        if (file.getAbsolutePath().equalsIgnoreCase(targetFile.getAbsolutePath())) {
            return;
        }
        boolean result = file.renameTo(targetFile);
        if (result) {
            System.out.println(String.format("文件从%s移动到%s成功！", file.getAbsolutePath(), targetFile.getAbsolutePath()));
        } else {
            System.out.println(String.format("文件从%s移动到%s失败！", file.getAbsolutePath(), targetFile.getAbsolutePath()));
        }
    }

    private static void handle(List<File> fileList, String rootPath) {
        for (File file : fileList) {
            moveFile(file, rootPath);
        }
    }

    public static void main(String[] args) {
        String rootPath = "G:/";
        List<File> fileList = new LinkedList<>();
        findFileList(new File(rootPath), fileList);
        handle(fileList, rootPath);
    }
}
