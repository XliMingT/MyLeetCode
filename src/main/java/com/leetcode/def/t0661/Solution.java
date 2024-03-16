package com.leetcode.def.t0661;

/**
 * @author XliMing
 * @date 2022/3/24 20:39
 */
public class Solution {
	public int[][] imageSmoother(int[][] img) {
		int m = img.length;
		int n = img[0].length;
		int[][] outImg = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				outImg[i][j] = getValue(i, j, img);
			}
		}
		return outImg;
	}

	private int getValue(int x, int y, int[][] img) {
		int ret = 0;
		int num = 0;
		int[] offsetX = new int[]{ -1, 0, 1};
		int[] offsetY = new int[]{ -1, 0, 1};
		for (int j : offsetX) {
			for (int k : offsetY) {
				int point = getPoint(x + j, y + k, img);
				if (point != -1) {
					++num;
					ret += point;
				}
			}
		}
		return num != 0 ? ret / num : 0;
	}

	private int getPoint(int x, int y, int[][] img) {
		int ret = -1;
		int m = img.length;
		int n = img[0].length;
		if ( x >= 0 && x < m && y >= 0 && y < n ) {
			ret = img[x][y];
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] img = new int[][]{{100,200,100},{200,50,200},{100,200,100}};
		int[][] ints = solution.imageSmoother(img);
		System.out.println("ints = " + ints);
	}
}
