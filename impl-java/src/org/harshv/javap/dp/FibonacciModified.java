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
 * Hacker Rank Problem: A series is defined in the following manner:
 * Given the nth and (n+1)th terms, the (n+2)th can be computed by the 
 * the relation: Tn+2 = (Tn+1)2 + Tn
 * So, if the first two terms of the series are 0 and 1: 
 * the third term = 12 + 0 = 1 
 * fourth term = 12 + 1 = 2 
 * fifth term = 22 + 1 = 5 
 * Given three integers A, B and N, such that the first two terms of
 * the series (1st and 2nd terms) are A and B respectively, compute 
 * the Nth term of the series.
 */

import java.math.BigInteger;

public class FibonacciModified {
	
	public static BigInteger getNthTerm(int A, int B, int N) {
		if (N == 1) {
			return BigInteger.valueOf(A);
	    } else if (N == 2) {
	    	return BigInteger.valueOf(B);
	    } else {
	        BigInteger bigA = BigInteger.valueOf(A);
	        BigInteger bigB = BigInteger.valueOf(B);
	        for (int j = 1 ; j <=N-2 ; j++) {
	            BigInteger bigC= bigA;
	            bigC = bigC.add(bigB.pow(2));
	            bigA = bigB;
	            bigB = bigC;
	        }
	        return bigB;
	    }
	}

	private static void test(String name, int A, int B, int N, String expetedResult) {
		BigInteger actualResult = getNthTerm(A, B, N);
		if (actualResult.compareTo(new BigInteger(expetedResult)) == 0) {
			System.out.println("Test case " + name + " successful with result: " + actualResult);
		} else {
			System.out.println("Test case " + name + " failed with result: " + actualResult);
		}
	}

	public static void main(String[] args) {
		test("test1", 0, 1, 5, "5");
		test("test2", 0, 1, 10, "84266613096281243382112");
	}    

}
