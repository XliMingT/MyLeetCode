package com.leetcode.t0635;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author XliMing
 * @Description -
 * @date 2022/3/21 0:16
 */
public class Solution {
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> allNum = getAllNum(root);

		Set<Integer> set = getSet(allNum);

		return set.contains(k);

	}

	private List<Integer> getAllNum(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		List<TreeNode> treeNodes = new LinkedList<>();
		treeNodes.add(root);
		while (!treeNodes.isEmpty()) {
			TreeNode treeNode = treeNodes.remove(0);
			list.add(treeNode.val);
			if (treeNode.left != null) {
				treeNodes.add(treeNode.left);
			}

			if (treeNode.right != null) {
				treeNodes.add(treeNode.right);
			}
		}
		return list;
	}

	private Set<Integer> getSet(List<Integer> list) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				set.add(list.get(i) + list.get(j));
			}
		}
		return set;
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
