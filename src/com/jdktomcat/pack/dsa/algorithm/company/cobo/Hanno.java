package com.jdktomcat.pack.dsa.algorithm.company.cobo;

public class Hanno {

    /**
     * 移动盘子
     *
     * @param disk   盘子
     * @param source 源柱
     * @param dis    目标柱
     */
    private static void move(int disk, char source, char dis) {
        System.out.println("编号：" + disk + " 盘子从柱：" + source + " 移动到柱：" + dis);
    }

    /**
     * 汉诺塔问题
     *
     * @param disk   盘子数
     * @param source 原始柱名称
     * @param assist 辅助柱名称
     * @param dis    目标柱名称
     */
    public static void hanno(int disk, char source, char assist, char dis) {
        if (disk == 1) {
            move(disk, source, dis);
            return;
        }
        hanno(disk - 1, source, dis, assist);
        move(disk, source, dis);
        hanno(disk - 1, assist, source, dis);
    }

    public static void main(String[] args) {
        int disk = 6;
        hanno(disk, 'A', 'B', 'C');
    }
}
