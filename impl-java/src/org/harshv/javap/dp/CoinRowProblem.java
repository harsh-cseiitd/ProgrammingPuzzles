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
 * Problem: There is a row of n coins whose values are some positive integers. These
 * values may not be distinct. The goal is to pick up the maximum amount of money
 * subject to the constraint that no two adjacent coins in the initial row can be
 * picked up.
 */

public class CoinRowProblem {
	
	/* A dynamic programming solution which returns max value
	 * subject to the problem constraints.
	 */
	
	public static int getMax(int values[]) {
		int[] maximums = new int[values.length];
		for (int i = 0; i < maximums.length; i++) {
			maximums[i] = 0;
		}
		maximums[0] = values[0];
		for (int j = 1; j < values.length; j++) {
			int prevMax  = maximums[j-1];
			int prev2max = 0;
			if (j-2 >= 0) {
				prev2max = maximums[j-2];
			}
			if (values[j] + prev2max > prevMax) {
				maximums[j] = values[j] + prev2max;
			} else {
				maximums[j] = prevMax;
			}
		}
		return maximums[maximums.length - 1];
	}
	
	private static void test(String name, int[] values, int expetedResult) {
		int actualResult = getMax(values);
		if (actualResult == expetedResult) {
			System.out.println("Test case " + name + " successful with result: " + actualResult);
		} else {
			System.out.println("Test case " + name + " failed with result: " + actualResult);
		}
	}

	/* procedure main is a testing method. */
	public static void main(String args[]) {
		test("test1", new int[] {5,1,2,10,6,2}, 17);
		test("test2", new int[] {5,1,2,10,6}, 15);
	}
}
