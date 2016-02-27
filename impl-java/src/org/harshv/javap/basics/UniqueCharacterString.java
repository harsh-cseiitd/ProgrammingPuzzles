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
 * Problem: decide if an input string is made up with unique characters
 * or not.
 */

package org.harshv.javap.basics;

import java.util.HashMap;

public class UniqueCharacterString {
 
	private static boolean computeWithExtraStorage(String inputStr) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < inputStr.length(); i++) {
			if (map.containsKey(inputStr.charAt(i))) {
				return false;
			} else {
				map.put(inputStr.charAt(i), 0);
			}			
		}
		return true;
	}

	private static boolean computeWithOutExtraStorage(String inputStr) {
		for (int i = 0; i < inputStr.length(); i++) {
			for (int j = i + 1; j < inputStr.length(); j++) {
				if (inputStr.charAt(i) == inputStr.charAt(j)) {
					return false;
				}
			}
		}
		return true;	
	}

	public static boolean decide(String inputStr, boolean inPlace) {
		boolean result = false;
		if (inPlace) {
			result = computeWithOutExtraStorage(inputStr);
		} else {
			result = computeWithExtraStorage(inputStr);
		}
		return result;
	}

	public static void test (String testname, String inputStr, boolean expectedResult) {
		boolean result1 = decide(inputStr, true);
		boolean result2 = decide(inputStr, false);

		if (result1 == expectedResult) {
			System.out.print(testname + " passed without Extra Storage");
		} else  {
			System.out.print(testname + " failed without Extra Storage");
		}

		if (result2 == expectedResult) {
			System.out.println(" and passed with Extra Storage");
		} else  {
			System.out.println(" and failed with Extra Storage");
		}
	}

	public static void main (String a[]) {
		test ("test1", "abcdefghijklmnopqrstuvwxyz", true);
		test ("test2", "0123456789", true);
		test ("test2", "aaabbbcccdddeeffgghhiijjkkllooppmmnnbbhhss", false);
		test ("test3", "abcedf", true);
		test ("test4", "78960", true);
		test ("test5", "01234567890asdfghjkl", false);
		test ("test6", " ", true);
		test ("test7", "harsh vardhan", false);
	}
}

