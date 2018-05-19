package com.anwar;

import java.util.HashSet;
import java.util.Set;

public class Solutions {
	static class Solution {
		public char firstUniqChar(String s) {
			int freq[] = new int[26];
			for (int i = 0; i < s.length(); i++)
				freq[s.charAt(i) - 'a']++;
			for (int i = 0; i < s.length(); i++)
				if (freq[s.charAt(i) - 'a'] == 1)
					return s.toCharArray()[i];
			return ' ';
		}
	}
	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().firstUniqChar("aaanww"));
	}
}
