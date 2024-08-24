package com.jdktomcat.pack.dsa.algorithm.company.cobo;

public class DoubleNearby {

    /**
     * 找出接近数字
     *
     * @param num 原始数字
     * @return 接近数字
     */
    public static double nearby(double num) {
        double floor = Math.floor(num);
        double floorH = floor + 1;
        double floorL = floor - 1;
        double floorF = floor + 0.49;
        double min = Math.abs(floorF - num);
        double result = floorF;
        double floorFH = floorH + 0.49;
        double floorFHA = Math.abs(floorFH - num);
        min = Math.min(min,floorFHA);
        if(min==floorFHA){
            result = floorFH;
        }
        double floorFL = floorL + 0.49;
        double floorFLA = Math.abs(floorFL - num);
        min = Math.min(min,floorFLA);
        if(min==floorFLA){
            result = floorFL;
        }
        double floorN = floor + 0.99;
        double floorNA = Math.abs(floorN - num);
        min = Math.min(min,floorNA);
        if(min==floorNA){
            result = floorN;
        }
        double floorNH = floorH + 0.99;
        double floorNHA = Math.abs(floorNH - num);
        min = Math.min(min,floorNHA);
        if(min==floorNHA){
            result = floorNH;
        }
        double floorNL = floorL + 0.99;
        double floorNLA = Math.abs(floorNL - num);
        min = Math.min(min, floorNLA);
        if(min==floorNLA){
            result = floorNL;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(nearby(12.01));
        System.out.println(nearby(12.61));
    }


}
