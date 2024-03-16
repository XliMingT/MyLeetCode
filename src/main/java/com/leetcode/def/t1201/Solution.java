package com.leetcode.def.t1201;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/19 22:05
 */
public class Solution {
	private long a;
	private long b;
	private long c;
	private long lcmAb;
	private long lcmBc;
	private long lcmAc;
	private long lcmAbc;

	public int nthUglyNumber(int n, int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.lcmAb = lcm(a, b);
		this.lcmBc = lcm(b, c);
		this.lcmAc = lcm(a, c);
		this.lcmAbc = lcm(this.lcmAb, c);

		long nLCM = countLcm(this.lcmAbc);

		long num = n / nLCM;
		long target = n % nLCM;

		long hi = this.lcmAbc;
		long lo = 0;
		while (hi > lo) {
			long mi = (hi + lo) / 2;
			if (countLcm(mi) < target) {
				lo = mi + 1;
			}
			else {
				hi = mi;
			}
		}

		return (int) (num * this.lcmAbc + lo);
	}

	private long lcm( long a, long b) {
		long remainder,m,n;
		m = Math.max(a, b);
		n = Math.min(a, b);
		while (n != 0) {
			remainder = m % n;
			m = n;
			n = remainder;

		}
		return a * b / m;
	}

	private long countLcm(long x) {
		return x/ a + x/ b + x/ c - x/ lcmAb - x/ lcmBc - x/ lcmAc + x/ lcmAbc;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		int i = solution.nthUglyNumber(3,2, 3, 5);
		System.out.println("i = " + i);
	}
}
