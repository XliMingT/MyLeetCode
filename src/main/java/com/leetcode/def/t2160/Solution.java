package com.leetcode.def.t2160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/22 0:27
 */
public class Solution {
	public int minimumSum(int num) {
		char[] numChars = String.valueOf(num).toCharArray();
		Arrays.sort(numChars);
		StringBuilder num1 = new StringBuilder();
		StringBuilder num2 = new StringBuilder();
		for (int i = numChars.length-1; i >= 0 ;) {
			num1.insert(0, numChars[i--]);
			num2.insert(0, numChars[i--]);
		}
		return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int i = solution.minimumSum(1039);
		System.out.println("i = " + i);
	}
}
