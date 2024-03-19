package com.leetcode.def.t0438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 默写一下官方解法2
 */
public class OfficialSolution2 {

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
        //设置参数，通过一个数组同时存入两个字符串的值，其中，s的滑动窗口+1，p字符串存入-1
        int[] count = new int[26];
        //计算初始值，也就是从0位开始的时候
        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        //初始值比较
        //设置一个值为比较值，这个值表示26个字符不同的数量
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }
        //判断存入0初始
        if(diff == 0) {
            returnList.add(0);
        }

        //开始循环
        for (int i = 1; i <= sLen-pLen; i++) {
            int outNum = s.charAt(i-1)-'a';
            int inNum = s.charAt(i+pLen-1)-'a';
            //滑动窗口后整理数据，删除滑出的，保存滑入的
            if (count[outNum] == 1) {
                //如果这个[1 ==> 0]，也就是这个字母将是从[不相同 ==> 相同]
                diff--;
            } else if (count[outNum] == 0) {
                //如果这个[0 ==> -1]，也就是这个字母将是从[相同 ==> 不相同]
                diff++;
            }
            //执行滑出操作
            count[outNum]--;

            if (count[inNum] == 0) {
                //如果这个[0 ==> 1]，也就是这个字母将是从[相同 ==> 不相同]
                diff++;
            } else if (count[inNum] == -1) {
                //如果这个[-1 ==> 0]，也就是这个字母将是从[不相同 ==> 相同]
                diff--;
            }
            count[inNum]++;
            //判断一下
            if(diff == 0) {
                returnList.add(i);
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
//        String s = "abab";
//        String p = "ab";
//        String s = "baa";
//        String p = "aa";
        List<Integer> anagrams = new OfficialSolution2().findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }
}
