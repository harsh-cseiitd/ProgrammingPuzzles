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

/** Given an array of positive numbers, find the maximum sum 
 * of a subsequence with the constraint that no 2 numbers in 
 * the sequence should be adjacent in the array
 * @author harshv
 *
 */
public class MaxSumNonAdjacentProblem {
	
	/* A dynamic programming solution which returns max sum
	 * subject to the problem constraints.
	 */
	public static int getMaxSum(int[] inputArray) {
		if (inputArray.length == 0) {
			return 0;
		}

		if (inputArray.length == 1) {
			return inputArray[0];
		}

		int[] tempSum = new int[inputArray.length +1];
		tempSum[0] = 0;
		tempSum[1] = inputArray[0];

		for (int i = 1; i < inputArray.length; i++) {
			int si = i+1;
			if (inputArray[i] + tempSum[si-2] >  tempSum[si-1]) {
				tempSum[si] = inputArray[i] + tempSum[si-2];
			} else {
				tempSum[si] = tempSum[si-1];
			}
		}
		return tempSum[tempSum.length-1];
	}

	private static void test(String name, int[] inputArray, int expetedResult) {
		int actualResult = getMaxSum(inputArray);
		if (actualResult == expetedResult) {
			System.out.println("Test case " + name + " successful with result :" + actualResult);
		} else {
			System.out.println("Test case " + name + " failed with result :" + actualResult);
		}
	}

	public static void main(String[] args) {
		test("test1", new int[] {5,  5, 10, 40, 50, 35}, 80);
		test("test2", new int[] {10, 5, 1, 15, 25, 50, 40}, 76);
	}
}
