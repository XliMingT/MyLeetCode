package com.leetcode.def.t1249;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author XliMing
 * @date 2022/3/23 14:40
 */
public class Solution {
	public String minRemoveToMakeValid(String s) {
		List<Integer> list = new ArrayList<>();

		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if ('(' == sb.charAt(i)) {
				list.add(i);
			}
			else if (')' == sb.charAt(i)) {
				if (list.isEmpty()) {
					sb.deleteCharAt(i);
					--i;
				} else {
					list.remove(list.size()-1);
				}
			}
		}
		int offset = 0;
		for (Integer integer : list) {
			sb.deleteCharAt(integer-offset);
			offset++;
		}
		return sb.toString().replace("()", "");
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = solution.minRemoveToMakeValid("))((");
		System.out.println("s = " + s);
	}
}
