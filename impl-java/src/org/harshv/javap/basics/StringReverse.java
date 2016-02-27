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
 * Problem: Reverse the input string.
 */

package org.harshv.javap.basics;

public class StringReverse {

	/*
	 * Time complexity: Linear 
	 * Space complexity: Linear 
	 */
	public static String reverse(String inputString) {
		char[] array = inputString.toCharArray();
		int index = 0;
		int indexFromLast = inputString.length() - 1;

		/*
		 * This loop runs half times the length of input string. So this 
		 * governs the time complexity of this solution.
		 */
		while(index < indexFromLast) {
			char temp = array[indexFromLast];
			array[indexFromLast] = array[index];
			array[index] = temp;
			index++;
			indexFromLast--;
		}
		return new String(array);
	}

	public static void test (String testname, String inputStr) {
		String result = reverse(inputStr);
		if (new StringBuilder(inputStr).reverse().toString().equals(result)) {
			System.out.println(testname + " passed with result: " + result);
		} else  {
			System.out.println(testname + " failed with result: " + result);
		}
	}

	public static void main(String[] args) {
		test ("test1", "abcdefghijklmnopqrstuvwxyz");
		test ("test2", "0123456789");
		test ("test2", "aaabbbcccdddeeffgghhiijjkkllooppmmnnbbhhss");
		test ("test3", "abcedf");
		test ("test4", "aaaaa");
		test ("test5", "alphabet");
		test ("test6", "");
		test ("test7", "harsh vardhan");

	}
}
