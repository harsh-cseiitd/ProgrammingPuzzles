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
 * Problem: Implement basic string compression. 
 * Example: 
 * Input string: xxyyyyzeepppppppp
 * Compressed String: x2y4z1e2p8 output: x2y4z1e2p8
 * Input string: xyzabcef
 * Compressed String: x1y1z1a1b1c1e1f1  output: xyzabcef
 * If length of compressed string is more than original 
 * string, return original string.
 * 
 * Junit: test/junit/basics/BasicStringCompressionTest.java
 */

package javap.basics;

public class BasicStringCompression {
	
	/**
	 * This solution returns compressed form of original string.
	 * Time complexity: Linear time (length of input string).
	 * Space Complexity: Linear space (length of result string).
	 */
	public static String getBasicCompressedString(String inputStr) {
		StringBuilder sb = new StringBuilder();
		char lastChar = inputStr.charAt(0);
		int index = 1;
		int repCount = 1;
		while (index <= inputStr.length()) {
			/**
			 * In case last few chars are repeated. append it to
			 * new string after string termination. This is a
			 * post processing step.
			 */
			if (index == inputStr.length()) {
				sb.append(lastChar);
				sb.append(repCount);
				break;
			}

			if (lastChar == inputStr.charAt(index)) {
				repCount++;
			} else {
				sb.append(lastChar);
				sb.append(repCount);
				repCount = 1;
				lastChar = inputStr.charAt(index);
			}
			index++;
		}
		if (sb.length() < inputStr.length()) {
			return sb.toString();
		}
		return inputStr;
	}
}
