package com.leetcode.def.t0606;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/22 23:55
 */
public class Solution {
	public String tree2str(TreeNode root) {
		StringBuilder stringBuilder = new StringBuilder();
		printTree(root, stringBuilder);
		return stringBuilder.toString();
	}

	private void printTree(TreeNode treeNode, StringBuilder stringBuilder) {
		if(treeNode == null) {
			return;
		}
		stringBuilder.append(treeNode.val);
		if (treeNode.left == null && treeNode.right == null) {
			return;
		}
		stringBuilder.append("(");
		printTree(treeNode.left, stringBuilder);
		stringBuilder.append(")");
		if (treeNode.right == null) {
			return;
		}
		stringBuilder.append("(");
		printTree(treeNode.right, stringBuilder);
		stringBuilder.append(")");
	}
}


class TreeNode {
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