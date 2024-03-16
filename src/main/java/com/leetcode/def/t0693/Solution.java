package com.leetcode.def.t0693;

/**
 * @author XliMing
 * @date 2022/3/28 16:36
 */
public class Solution {
	public boolean hasAlternatingBits(int n) {
		boolean rut = true;
		int x = n & 1;
		while (n != 0) {
			if ((n & 1) != x) {
				rut = false;
				break;
			}
			n = n >>> 1;
			x ^= 1;
		}
		return rut;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean b = solution.hasAlternatingBits(11);
		System.out.println("b = " + b);
	}
}
