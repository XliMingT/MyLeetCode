package com.leetcode.t0440;

import java.util.LinkedList;
import java.util.List;

/**
 * @author XliMing
 * @date 2022/3/23 16:07
 */
public class Solution {
	public int findKthNumber(int n, int k) {

		return out1(1);
	}

	private int outLevel(int m, int n) {
		List<Integer> num = getNumList(n);
		if (num.get(0) >= m) {
			return out1(num.get(0)) * (m) + 1;
		}
		else {
			int mm = n - out9(num.size()-1);
			return out1(num.size()-1) * (m) + mm + 1;
		}
	}

	private int outLevelM(int x, int n) {
		int m = 0;
		boolean flag = true;
		for (int i = 1; i < 10; i++) {
			if (x <= outLevel(i, n)) {
				m = i-1;
				flag = false;
				break;
			}
		}
		if (flag) {
			m = 9;
		}
		return m;
	}



	private int out1(int n) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			num += 1;
			if (i != n-1) {
				num *= 10;
			}
		}
		return num;
	}

	private int out9(int n) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			num += 9;
			if (i != n-1) {
				num *= 10;
			}
		}
		return num;
	}

	private List<Integer> getNumList(int n) {
		List<Integer> num = new LinkedList<>();
		while (n > 0) {
			num.add(0, n % 10);
			n = n /10;
		}
		return num;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		int kthNumber = solution.findKthNumber(6359, 2);
		System.out.println("kthNumber = " + kthNumber);
		System.out.println(solution.outLevelM(2 , 13));
		//System.out.println(solution.outLevel(2, 13));
	}
}
