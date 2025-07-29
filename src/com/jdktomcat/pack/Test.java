package com.jdktomcat.pack;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-08-19 20:53
 */
public class Test {


    public static Boolean isRightAlipayAccount(String bankNumber){
        Boolean isRightBankNumber = Boolean.FALSE;
        if (bankNumber.contains("@")){
            return Boolean.TRUE;
        }else {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher matcher = pattern.matcher(bankNumber);
            isRightBankNumber = matcher.matches();
            if (isRightBankNumber && bankNumber.trim().length() == 11 && bankNumber.startsWith("1")){
                isRightBankNumber = Boolean.TRUE;
            }else {
                isRightBankNumber = Boolean.FALSE;
            }
        }
        return isRightBankNumber;
    }

    public static void main(String[] args) {
        String configMerchantIdsValue = " 13129532596";
        System.out.println(isRightAlipayAccount(configMerchantIdsValue));
    }
}
