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

/**
 * Problem: Two strings are called isomorphic if length of these
 * two strings are same and there is a one to one mapping possible
 * for every unique character of first string to every unique 
 * character of second string.
 * So if all characters in first string are replaced by above
 * possible mapping, we get second string.
 * 
 * Task is to determine if two input strings are isomorphic or not.
 * 
 * Junit: test/junit/basics/StringIsomorphismTest.java
 */

package javap.basics;

import java.util.HashMap;

public class StringIsomorphism {

	/**
	 * This solution returns boolean response if two input strings are
	 * isomorphic.
	 * Time complexity: Linear time (length of input string).
	 * Space Complexity: Linear space (size of the map and size of transformed string).
	 */
	public static boolean decideIsomorphism(String inputStr1, String inputStr2) { 
		 /* 
		  * Strings can't be isomorphic if their length are not equal.
		  */
		if (inputStr1.length() != inputStr2.length()) {
			return false;
		}
		HashMap<Character, Character> mapping = new HashMap<Character, Character>();
		StringBuilder transformString1 = new StringBuilder();
		for (int index = 0; index < inputStr1.length(); index++) {
			char ch = inputStr1.charAt(index);
			/* 
			 * If mapping exist for this character then use it else create the mapping.
			 */
			if (mapping.containsKey(ch)) {
				transformString1.append(mapping.get(ch));
			} else {
				mapping.put(ch, inputStr2.charAt(index));
				transformString1.append(mapping.get(ch));
			}
		}
		if (transformString1.toString().equals(inputStr2)) {
			return true;
		}
		return false;
	}

}
