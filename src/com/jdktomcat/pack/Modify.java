package com.jdktomcat.pack;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2018-08-01
 */
public class Modify {

    public static void main(String[] args) throws Exception {
        BigDecimal acc = new BigDecimal("2000");
        String totalAmount = "800,200,100";
        String[] splitAmount = totalAmount.split(",");
        double sumAmount = 0.0;
        for (String amount : splitAmount) {
            sumAmount += Double.valueOf(amount);
        }
        if (new BigDecimal(sumAmount).compareTo(acc) != 0) {
            System.out.println("1");
        }else{
            System.out.println("2");
        }
    }
}