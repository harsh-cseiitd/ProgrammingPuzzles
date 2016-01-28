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

package org.harshv.javap.greedy;

/*
 * Hacker Rank Problem: Suppose we have the share price prediction of 
 * a company for the next N days.
 * Each day, you can either buy one share, sell any number of shares
 * that you own, or not make any transaction at all. What is the maximum
 * profit you can obtain with an optimum trading strategy?
 */

public class StockMaximizeProblem {

	public static int getMaxElementIndex(int[] stockPrices, int start, int end) {
		if ( start >= end) {
			return -1;
		}
		int maxIndex = start;
        for (int i = start+1 ; i < end ; i++) {
            if (stockPrices[maxIndex] < stockPrices[i] ) {
                maxIndex = i;
            }
        }
        return maxIndex;
	}

    public static long getProfit(int[] stockPrices) {
    	long profit  = 0L;
    	int maxIndex = -1;

    	for (int j = 0 ; j < stockPrices.length; j++) {
    		if (maxIndex == -1 ||  j > maxIndex) {
    			maxIndex = getMaxElementIndex(stockPrices, j+1, stockPrices.length);
    		}

    		if (maxIndex > -1 && stockPrices[j] < stockPrices[maxIndex]) {
    			profit = profit + ((long) stockPrices[maxIndex] - (long) stockPrices[j]);
    		}
    	}
        return profit;
    }

	private static void test(String name, int[] prices, long expetedResult) {
		long actualResult = getProfit(prices);
		if (actualResult == expetedResult) {
			System.out.println("Test case " + name + " successful with result: " + actualResult);
		} else {
			System.out.println("Test case " + name + " failed with result: " + actualResult);
		}
	}

	public static void main(String[] args) {
		test("test1", new int[] {5, 3, 2}, 0);
		test("test1", new int[] {1, 2, 100}, 197);
		test("test1", new int[] {1, 3, 1, 2}, 3);
	}

}
