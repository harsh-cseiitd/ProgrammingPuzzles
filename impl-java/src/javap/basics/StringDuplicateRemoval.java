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
 * 
 * Junit: test/junit/basics/StringDuplicateRemovalTest.java
 */

package javap.basics;

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

}
