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

package org.harshv.javap.dp;

import java.util.Arrays;

/*
 * Problem: Given an array of real numbers. Find count of unique triplets in
 * that array whose sum is zero.
 */

public class ThreeSumProblem {
	
	/* A dynamic programming solution which returns count of triplets
	 * having sum equal to input value. Time complexity is O(n2). It can't
	 * be solved in less than that.
	 */

	public static int getTripletCount(int[] arrayOfNums) {
		int tripletCount = 0;
		Arrays.sort(arrayOfNums);
		for (int firstIndex = 0; firstIndex < arrayOfNums.length -1; firstIndex++) {
			int secondIndex = firstIndex + 1;
			int thirdIndex  = arrayOfNums.length - 1;
			while (secondIndex < thirdIndex) {
				int val = (arrayOfNums[firstIndex] + arrayOfNums[secondIndex] + arrayOfNums[thirdIndex]);
				if (val < 0) {
					secondIndex = secondIndex + 1;
				} else if (val > 0) {
					thirdIndex = thirdIndex - 1;
				} else {
					tripletCount++;
					thirdIndex  = thirdIndex - 1;
					secondIndex = secondIndex + 1;
				}
			}
		}
		return tripletCount;
	}

	private static void test(String name, int[] dims, int expetedResult) {
		int actualResult = getTripletCount(dims);
		if (actualResult == expetedResult) {
			System.out.println("Test case " + name + " successful with result :" + actualResult);
		} else {
			System.out.println("Test case " + name + " failed with result :" + actualResult);
		}
	}

	public static void main(String[] args) {
		test("test1", new int[] {30, -40, -20, -10, 40, 0, 10, 5}, 4);
		test("test1", new int[] {-25, -10, -7, -3, 2, 4, 8, 10}, 2);
	}
}
