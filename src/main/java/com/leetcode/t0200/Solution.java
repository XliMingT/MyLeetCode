package com.leetcode.t0200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/21 23:17
 */
public class Solution {
	public int numIslands(char[][] grid) {
		int landsNum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					++landsNum;
					dfs(grid, i, j);
				}
			}
		}
		return landsNum;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '2';
		dfs(grid,i-1, j);
		dfs(grid,i, j-1);
		dfs(grid,i+1, j);
		dfs(grid,i, j+1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] grid = new char[][] {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		char[][] grid1 = new char[][] {
				{'1','1','1'},
				{'0','1','0'},
				{'1','1','1'}
		};

		int i = solution.numIslands(grid);
		System.out.println("i = " + i);

	}
}
