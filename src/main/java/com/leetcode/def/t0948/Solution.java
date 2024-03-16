package com.leetcode.def.t0948;

import java.util.Arrays;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/20 0:40
 */
public class Solution {
	private int i;
	private int j;
	private int power;

	public int bagOfTokensScore(int[] tokens, int power) {
		Arrays.sort(tokens);
		i = 0;
		j = tokens.length;
		this.power = power;
		int score;
		int score1 = 0;
		do {
			score = score1;
			score1 = p2s(tokens, score);
		} while (score < score1);
		return score;
	}

	private int p2s(int[] tokens, int score) {
		int mi = getMi(tokens, i, j);
		while (j > mi && score > 0) {
			power += tokens[--j];
			--score;
		}
		while (i <= mi && tokens[i] <= power) {
			power -= tokens[i++];
			++score;
		}
		return score;
	}

	private int getMi(int[] tokens, int i, int j) {
		int total = power;
		for (int k = i; k < j; k++) {
			total += tokens[k];
		}
		int miTotal = total / 2;
		int total2 = 0;
		int kk = i;
		while (miTotal >= total2 && kk < j) {
			total2 += tokens[kk];
			++kk;
		}
		return kk-1;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		int i = solution.bagOfTokensScore(new int[] { }, 200);
		System.out.println("i = " + i);
	}
}
