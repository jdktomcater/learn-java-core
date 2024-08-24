package com.jdktomcat.pack.dsa.algorithm.redblacktree;

/**
 * 类描述：红黑树颜色枚举
 *
 * @author 汤旗
 * @date 2019-05-29 10:30
 */
public enum RedBlackColorEnum {
    /**
     * 黑节点
     */
    BLACK(0, "黑"),

    /**
     * 红节点
     */
    RED(1, "红");

    /**
     * 颜色值 黑:0 红:1
     */
    private int color;

    /**
     * 描述
     */
    private String desc;

    RedBlackColorEnum(int color, String desc) {
        this.color = color;
        this.desc = desc;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
