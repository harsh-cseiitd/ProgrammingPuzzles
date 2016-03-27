/*
 * Copyright (C) 2016 Harsh Vardhan
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
 * Problem: Check is two input strings are anagrams or not!
 * 
 * Junit: test/junit/basics/DecideAnagramsTest.java
 */

package javap.basics;

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
}
