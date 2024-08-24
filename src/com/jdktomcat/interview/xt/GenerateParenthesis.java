package com.jdktomcat.interview.xt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, "", result);
        return result;
    }


    private static void dfs(int lc, int rc, String parenthesis, List<String> result) {
        if (lc == 0 && rc == 0) {
            result.add(parenthesis);
        } else if (lc >= 0 && rc >= 0) {
            dfs(lc - 1, rc, parenthesis + "(", result);
            if (rc > lc) {
                dfs(lc, rc - 1, parenthesis + ")", result);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(Arrays.toString(result.toArray()));
    }


}
