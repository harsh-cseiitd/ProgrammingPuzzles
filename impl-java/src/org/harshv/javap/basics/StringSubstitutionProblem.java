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
 * Problem: In input string, replace all occurrences of input character with 
 * given pattern.
 */

package org.harshv.javap.basics;

public class StringSubstitutionProblem {

	/*
	 * First solution: In traditional way using char array.
	 */
	public static String subsitute1(String str, char candidate, String pattern) {
		int charCount = 0;
		/*
		 * First count number of occurrences of given character so that we can
		 * judge the required space for expansion.
		 */
		for (int i = 0; i <str.length(); i++) {
			if (str.charAt(i) == candidate) {
				charCount++;
			}
		}

		int resultArrayLength = str.length() + ((pattern.length()-1) * charCount);
		char[] resultStr = new char[resultArrayLength];

		int rIndex = resultArrayLength;
		for (int j = str.length() -1 ; j >= 0; j--) {
			if (str.charAt(j) == candidate) {
				int pMaxIndex = pattern.length() -1;
				for (int p = 0 ; p <= pMaxIndex; p++) {
					rIndex = rIndex - 1;
					resultStr[rIndex] = pattern.charAt(pMaxIndex - p);
				}
			} else {
				rIndex = rIndex -1;
				resultStr[rIndex] = str.charAt(j);
			}
		}
		return new String(resultStr);
	}
	
	/*
	 * Second solution: using StringBuilder.
	 */
	public static String subsitute2(String str, char candidate, String pattern) {
		
		StringBuilder sb = new StringBuilder();
		for (int j = 0 ; j < str.length(); j++) {
			if (str.charAt(j) == candidate) {
				for (int p = 0 ; p < pattern.length(); p++) {
					sb.append(pattern.charAt(p));
				}
			} else {
				sb.append(str.charAt(j));
			}
		}
		return sb.toString();
	}

	public static void test (String testname, String inputStr, char ch, String pattern, String expectedResult) {
		String result1 = subsitute1(inputStr, ch, pattern);
		if (result1.equals(expectedResult)) {
			System.out.println(testname + " with approach1 passed with result: " + result1);
		} else  {
			System.out.println(testname + " with approach1 failed with result: " + result1);
		}
		
		String result2 = subsitute2(inputStr, ch, pattern);
		if (result2.equals(expectedResult)) {
			System.out.println(testname + " with approach2 passed with result: " + result2);
		} else  {
			System.out.println(testname + " with approach2 failed with result: " + result2);
		}
	}

	public static void main(String[] args) {
		test ("test1", "AB CD EF GH", ' ', "X", "ABXCDXEFXGH");
		test ("test2", " AB CD EF GH ", ' ', "X", "XABXCDXEFXGHX");
		test ("test3", "A B C D E F G H", ' ', "Y", "AYBYCYDYEYFYGYH");
		test ("test4", "  ", ' ', "Y", "YY");
		test ("test5", "AB CD EF GH", ' ', "%20", "AB%20CD%20EF%20GH");
		test ("test6", " AB CD EF GH ", ' ', "%20", "%20AB%20CD%20EF%20GH%20");
		test ("test7", "A B C D E F G H", ' ', "%20", "A%20B%20C%20D%20E%20F%20G%20H");
	}
}
