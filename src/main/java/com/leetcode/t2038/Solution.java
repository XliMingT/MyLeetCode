package com.leetcode.t2038;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/22 23:37
 */
public class Solution {
	public boolean winnerOfGame(String colors) {
		if (colors.length() <= 2) {
			return false;
		}
		int x=0;
		int y=0;
		for (int i = 1; i < colors.length()-1; i++) {
			if (colors.charAt(i-1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i+1) == 'A') {
				++x;
			}
			else if (colors.charAt(i-1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i+1) == 'B') {
				++y;
			}
		}
		return x > y;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean b = solution.winnerOfGame("ABBBBBBBAAA");
		System.out.println("b = " + b);
	}
}
