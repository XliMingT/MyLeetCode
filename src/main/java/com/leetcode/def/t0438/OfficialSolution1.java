package com.leetcode.def.t0438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 默写一下官方解法1
 */
public class OfficialSolution1 {

    public List<Integer> findAnagrams(String s, String p) {
        //长度
        int sLen = s.length();
        int pLen = p.length();
        //判断异常
        if (sLen < pLen) {
            return Collections.emptyList();
        }
        //返回值
        List<Integer> returnList = new ArrayList<>();
        //设置参数，两个字符的数据统计（其中s是滑动窗口的，并不是s的全部字符）
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //计算初始值，也就是从0位开始的时候
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        //初始值比较
        if (Arrays.equals(sCount, pCount)) {
            //初始值也就是从0开始
            returnList.add(0);
        }
        //开始循环
        for (int i = 1; i <= sLen-pLen; i++) {
            //滑动窗口后整理数据，删除滑出的，保存滑入的
            sCount[s.charAt(i-1)-'a']--;
            sCount[s.charAt(i+pLen-1)-'a']++;
            //判断一下
            if (Arrays.equals(sCount, pCount)) {
                //初始值也就是从0开始
                returnList.add(i);
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = new OfficialSolution1().findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }
}
