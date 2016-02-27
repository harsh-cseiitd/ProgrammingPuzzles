package org.harshv.javap.basics;

import java.util.HashMap;

public class DecideAnagrams {

	public static boolean decideAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		/*
		 * Count occurrences of each character of input string1.
		 */
		for (int j = 0; j < str1.length(); j++) {
			char ch = str1.charAt(j);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		
		/*
		 * Input string2 should have same char set as string1 and also 
		 * frequency of each occurrence should be same. 
		 */
		for (int j = 0; j < str2.length(); j++) {
			char ch = str2.charAt(j);
			if (map.containsKey(ch)) {
				int value = map.get(ch);
				if (value == 1) {
					map.remove(ch);
				} else if (value > 1){
					map.put(ch, value - 1);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		/*
		 * check if map has any record. if it has that means str1 has some
		 * characters which are not part of str2. 
		 */
		if (map.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void test (String testname, String inputStr1, String inputStr2, boolean expectedResult) {
		boolean result = decideAnagrams(inputStr1, inputStr2);
		if (result == expectedResult) {
			System.out.println(testname + " passed with result: " + result);
		} else  {
			System.out.println(testname + " failed with result: " + result);
		}
	}

	public static void main(String[] args) {
		test ("test1", "army", "mary", true);
		test ("test2", "abcdef", "abcdef", true);
		test ("test3", "abcdef", "fedcba", true);
		test ("test4", "word", "wrdo", true);
		test ("test5", "stop", "tops", true);
		test ("test6", "boat", "btoa", true);
		test ("test7", "fill", "fil", false);
		test ("test8", "ccc", "ccccccc", false);
		test ("test9", "sleep", "slep", false);
	}
}
