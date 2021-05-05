package com.lesssoda.leetcode;

/**
 * @author Lee
 * @since 2021/4/26 20:38
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
        Integer
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
    }
}
