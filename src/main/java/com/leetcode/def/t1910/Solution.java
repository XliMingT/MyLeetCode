package com.leetcode.def.t1910;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/21 9:50
 */
public class Solution {
	public String removeOccurrences(String s, String part) {
		while (s.contains(part)) {
			s = s.replaceFirst(part, "");
		}
		return s;
	}
}
