package com.leetcode.t0108;

/**
 * @author XliMing
 * @date 2023/6/14 20:05
 */
public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
    TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
