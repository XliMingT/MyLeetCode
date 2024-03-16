package com.leetcode.def.t0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XliMing
 * @date 2023/11/21 18:33
 */
public class Solution {

	public static void main(String[] args) {
		List<List<String>> lists = new Solution().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		System.out.println("lists = " + lists);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return Collections.emptyList();
		}
		Map<String, List<String>> theMapList = new HashMap<>();
		for (String str : strs) {
			String key = getOnlyType(str);
			if (theMapList.containsKey(key)) {
				theMapList.get(key).add(str);
			} else {
				theMapList.put(key, new ArrayList<>());
				theMapList.get(key).add(str);
			}
		}

		List<List<String>> lists = new ArrayList<>();
		theMapList.forEach((k, v)-> lists.add(v));
		return lists;
	}

	public String getOnlyType(String str) {
		if (str == null) {
			return "";
		}
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}
}
