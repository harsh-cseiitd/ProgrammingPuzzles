/*
 * Copyright (C) 2015 Harsh Vardhan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Problem: Remove duplicate characters from input string.
 */

package org.harshv.javap.basics;

import java.util.HashMap;

public class StringDuplicateRemoval {

	/*
	 * This solution adds first occurrence of each char in new string.
	 * Time complexity: Linear time.
	 * Space Complexity: Linear space.
	 */
	public static String getUniqueCharString(String inputStr) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder sb = new StringBuilder(inputStr.length());
		/*
		 * Count occurrences of each character in input String.
		 */
		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}			
		}
		
		/*
		 * If occurrence exist in map then add that char in new string and
		 * also remove that record from map. So a char is guaranteed to be
		 * present only once in result string.
		 */
		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			if (map.containsKey(ch)) {
				sb.append(ch);
				map.remove(ch);
			}	
		}
		return sb.toString();
	}

	public static void test (String testname, String inputStr, String expectedResult) {
		String result = getUniqueCharString(inputStr);
		if (result.equals(expectedResult)) {
			System.out.println(testname + " passed with result: " + result);
		} else  {
			System.out.println(testname + " failed with result: " + result);
		}
	}

	public static void main(String[] args) {
		test ("test1", "abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz");
		test ("test2", "0123456789", "0123456789");
		test ("test2", "aaabbbcccdddeeffgghhiijjkkllooppmmnnbbhhss", "abcdefghijklopmnbhs");
		test ("test3", "abcedf", "abcedf");
		test ("test4", "aaaaa", "a");
		test ("test5", "alphabet", "alphabet");
		test ("test6", "", "");
		test ("test7", "harsh vardhan", "hars vdn");
	}
}
