package com.leetcode.def.t0438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        StringCompare stringCompare = new StringCompare(p);

        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i <= sLen - pLen; i++) {
            if(stringCompare.compare(s.substring(i, i+pLen))) {
                returnList.add(i);
            }
        }
        return returnList;
    }

    class StringCompare {

        private final int[] COUNT = new int[26];

        public StringCompare(String str) {
            for (char c : str.toCharArray()) {
                COUNT[c - 'a']++;
            }
        }

        public boolean compare(String newStr) {
            int[] list = new int[26];
            for (char i : newStr.toCharArray()) {
                list[i - 'a']++;
            }
            return Arrays.equals(COUNT, list);
        }
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = new Solution().findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }
}
