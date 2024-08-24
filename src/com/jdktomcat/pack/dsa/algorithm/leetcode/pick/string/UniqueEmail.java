package com.jdktomcat.pack.dsa.algorithm.leetcode.pick.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {

    private static int numUniqueEmails(String[] emails) {
        Set<String> addrSet = new HashSet<>();
        for (String email : emails) {
            String localAddr = email.split("@")[0];
            String domainAddr = email.split("@")[1];
            localAddr = localAddr.replaceAll("\\.", "");
            int index = localAddr.indexOf("+");
            if (index != -1) {
                localAddr = localAddr.substring(0, localAddr.indexOf("+"));
            }
            addrSet.add(localAddr + "@" + domainAddr);
        }
        return addrSet.size();
    }

    public static void main(String[] args) {
        String[] targetEmails = new String[]{"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(targetEmails));
    }
}
