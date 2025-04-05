package com.jdktomcat.pack;

import java.util.Arrays;
import java.util.List;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-08-19 20:53
 */
public class Test {

    public static void main(String[] args) {
        String configMerchantIdsValue = " 201376,201421,201422";
        Integer merchantId = 201376;
        List<String> configMerchantIds = Arrays.asList(configMerchantIdsValue.replace(" ", "").split(","));
        System.out.println(configMerchantIds.contains(String.valueOf(merchantId)));
    }
}
