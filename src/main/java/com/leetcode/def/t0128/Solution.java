package com.leetcode.def.t0128;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XliMing
 * @date 2023/11/21 21:22
 */
public class Solution {

	public static void main(String[] args) {
		int i = new Solution().longestConsecutive(new int[] { 9,1,4,7,3,-1,0,5,8,-1,6 });
		System.out.println("i = " + i);
	}


	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> nodeSize = new HashMap<>();
		for (int num : nums) {
			nodeSize.put(num, 1);
		}

		for (int num : nums) {
			int size = getNode(nodeSize, num);
			if (nodeSize.containsKey(num-1)){
				nodeSize.put(num-1, nodeSize.get(num-1) + size);
			} else if (size > 0){
				nodeSize.put(num, size);
			}
		}

		return nodeSize.isEmpty() ? 0 : Collections.max(nodeSize.values());
	}

	public int getNode(Map<Integer, Integer> nodeSize, int num) {
		if (!nodeSize.containsKey(num)) {
			return 0;
		}
		int size = nodeSize.get(num) + getNode(nodeSize, num+1);
		nodeSize.remove(num);
		return size;
	}

}
