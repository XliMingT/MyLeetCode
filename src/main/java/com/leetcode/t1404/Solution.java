package com.leetcode.t1404;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/19 17:39
 */
public class Solution {
	public int numSteps(String s) {
		int step = 0;
		while (!"1".equals(s)) {
			System.out.println("switchNum = " + s);
			s = compute(s);
			step++;
		}
		return step;
	}


	private String compute(String a) {
		int length = a.length();
		char[] chars = a.toCharArray();
		if (chars[length-1] == '0') {
			chars = divideTwo(chars);
		} else {
			chars = addOne(chars);
		}
		return String.valueOf(chars);
	}

	private char[] addOne(char[] chars) {
		for (int i = chars.length-1; i >= 0; i--) {
			if ('1' == chars[i]) {
				chars[i] = '0';
			}
			else {
				chars[i] = '1';
				return chars;
			}

		}
		char[] chars1 = new char[chars.length + 1];
		chars1[0] = '1';
		for (int i = 1; i < chars1.length; i++) {
			chars1[i] = '0';
		}
		return chars1;
	}

	private char[] divideTwo(char[] chars) {
		char[] chars1 = new char[chars.length - 1];
		for (int i = 0; i < chars1.length; i++) {
			chars1[i] = chars[i];
		}
		return chars1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int i = solution.numSteps("1111011110000011100000110001011011110010111001010111110001");
		System.out.println("i = " + i);
		
		char c = 48;
		System.out.println("c = " + c);
	}
}
