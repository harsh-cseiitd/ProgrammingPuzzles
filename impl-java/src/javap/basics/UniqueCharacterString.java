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
 * 
 * Junit:
 */

package javap.basics;

import java.util.HashMap;

public class UniqueCharacterString {
 
	public static boolean computeWithExtraStorage(String inputStr) {
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

	public static boolean computeWithOutExtraStorage(String inputStr) {
		for (int i = 0; i < inputStr.length(); i++) {
			for (int j = i + 1; j < inputStr.length(); j++) {
				if (inputStr.charAt(i) == inputStr.charAt(j)) {
					return false;
				}
			}
		}
		return true;	
	}
}

