package com.leetcode.def.t1309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/20 2:17
 */
public class Solution {
	public String freqAlphabets(String s) {
		StringBuilder result = new StringBuilder();
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#'){
				for (int j = k; j < i-2; j++) {
					result.append((char) (s.charAt(j) - 49 + 97));
				}
				result.append((char) ((s.charAt(i-2)-48)*10 + s.charAt(i-1)-48 + 96));
				k = i+1;
			}
		}
		for (int j = k; j < s.length(); j++) {
			result.append((char) (s.charAt(j)-49 + 97));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String i = solution.freqAlphabets("1326#");
		System.out.println("i = " + i);
	}
}
