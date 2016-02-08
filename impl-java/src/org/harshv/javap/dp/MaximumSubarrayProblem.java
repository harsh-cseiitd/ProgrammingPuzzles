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
 * Hacker Rank Problem: Given an array, find the maximum possible sum of a
 * Contiguous subarray as well as Non-contiguous (not necessarily contiguous)
 * subarray. Empty array are not valid inputs.
 */

public class MaximumSubarrayProblem {

	public static int getMaxValue(int[] array){  
        int maxValue = array[0];  
        for (int i=1; i < array.length; i++){  
            if (array[i] > maxValue){  
                maxValue = array[i];  
            }  
        }  
       return maxValue;  
	}

	public static long getMaxSumContiguousSubarray(int[] numArray) {
		/* if input array has only one element then max sum is
		/* that element only. */
		if (numArray.length == 1) {
			return numArray[0];
		}

		long [] maxSubArray  = new long[numArray.length];
		maxSubArray[0] = numArray[0];
		long maxSum = maxSubArray[0];
        
		/* Visit each element of the input array and keep maximum sum up to
		 * previous element. Max sum for a element is that element value If
		 * (current element + previous sum) is not positive OR that current
		 * element is negative and reducing value of (current element + previous sum).
		 * Otherwise  Max sum for a element is (current element + previous sum).
		 */
		for (int i = 1; i < numArray.length; i++) {
			long current  = (long) numArray[i];
			long currentAndPreviousSum  = current + maxSubArray[i-1];
			if ((currentAndPreviousSum <= 0) || (maxSubArray[i-1] < 0 && current > 0)) {
				maxSubArray[i] = current;
			} else {
				maxSubArray[i] = currentAndPreviousSum ;
			}
			if (maxSubArray[i] > maxSum) {
				maxSum = maxSubArray[i];
			}
		}
		return maxSum;
	}

	public static long getMaxSumNonContiguousSubarray(int[] numArray) {
		if (numArray.length == 1) {
			return numArray[0];
		}
		/* if array has all negative or zero values then max value is either zero
		/* or just least negative number. */
		int maxValue = getMaxValue(numArray);
		if (maxValue <= 0) {
			return maxValue;
		}

		/* if the array has few positive numbers then pick them all, sum and return the sum */
		long maxSum = 0;
		for (int i = 0 ; i < numArray.length ; i++) {
			if (numArray[i] > 0 ) {
				maxSum = maxSum + (long) numArray[i];
			}	
		}
		return maxSum;
	}

  
	private static void test(String name, int[] values, int eContiniousResult, int eNonContiniousResult) {
		long aContiniousResult    = getMaxSumContiguousSubarray(values);
		long aNonContiniousResult = getMaxSumNonContiguousSubarray(values);

		if ((aContiniousResult == eContiniousResult) &&
				(aNonContiniousResult == eNonContiniousResult)) {
			System.out.println("Test case " + name + " successful with both result: " + aContiniousResult + " " + aNonContiniousResult);
		} else if (aContiniousResult == eContiniousResult){
			System.out.println("Test case " + name + " successful with continious result: " + aContiniousResult);
			System.out.println("Test case " + name + " failed with non continious result: " + aNonContiniousResult);
		} else if (aNonContiniousResult == eNonContiniousResult) {
			System.out.println("Test case " + name + " failed with continious result: " + aContiniousResult);
			System.out.println("Test case " + name + " successful with non continious result: " + aNonContiniousResult);
		} else {
			System.out.println("Test case " + name + " failed with continious result: " + aContiniousResult);
			System.out.println("Test case " + name + " failed with non continious result: " + aNonContiniousResult);
		}
	}

	/* procedure main is a testing method. */
	public static void main(String args[]) {
		test("test1", new int[] {4}, 4, 4);
		test("test2", new int[] {-3, -6}, -3, -3);
		test("test3", new int[] {1, 5, 11}, 17, 17);
		test("test3", new int[] {11, 6, 2}, 19, 19);
		test("test4", new int[] {-18}, -18, -18);
		test("test5", new int[] {2, -2, -2 ,-2, -2 ,8}, 8, 10);
		test("test6", new int[] {2, -1, 2, 3, 4, -5}, 10, 11);
	}
}
