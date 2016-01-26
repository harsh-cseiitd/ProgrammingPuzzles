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

/*
 * Problem: There are m coin denominations. The lowest value in denominations
 * is always 1. The goal is to provide change of a value n with minimum coins
 * denominations.
 * 
 */

public class ChangeMakingProblem {

	/* A dynamic programming solution which returns max value
	 * subject to the problem constraints.
	 */
	
	public static int getMinDenominations(int[] dims, int value) {
		int[] minDimsList = new int[value+1];
		minDimsList[0] = 0;
		for (int val = 1; val <= value; val++) {
			int minDims = Integer.MAX_VALUE;
			for (int d = 0; d < dims.length; d++) {
				if (val - dims[d] >=0) {
					minDims = Integer.min(minDimsList[val - dims[d]], minDims);
				}
			}
			minDimsList[val] = minDims + 1;
		}
		return minDimsList[minDimsList.length-1];
	}

	private static void test(String name, int[] dims, int value, int expetedResult) {
		int actualResult = getMinDenominations(dims, value);
		if (actualResult == expetedResult) {
			System.out.println("Test case " + name + " successful with result :" + actualResult);
		} else {
			System.out.println("Test case " + name + " failed with result :" + actualResult);
		}
	}

	public static void main(String[] args) {
		test("test1", new int[] {1,3,4}, 6,2);
		test("test2", new int[] {1,3,5}, 9,3);
	}
}
