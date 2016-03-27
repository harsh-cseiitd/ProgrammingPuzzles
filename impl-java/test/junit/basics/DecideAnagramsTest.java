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

package junit.basics;

import static org.junit.Assert.*;
import javap.basics.DecideAnagrams;

import org.junit.Test;

public class DecideAnagramsTest {

	@Test
	public void testAnagrams() {
		testHelper ("test1", "army", "mary", true);
		testHelper ("test2", "abcdef", "abcdef", true);
		testHelper ("test3", "abcdef", "fedcba", true);
		testHelper ("test4", "word", "wrdo", true);
		testHelper ("test5", "stop", "tops", true);
		testHelper ("test6", "boat", "btoa", true);
		testHelper ("test7", "fill", "fil", false);
		testHelper ("test8", "ccc", "ccccccc", false);
		testHelper ("test9", "sleep", "slep", false);
	}
	
	private void testHelper(String testname, String inputStr1, String inputStr2, boolean expectedResult) {
		boolean actual = DecideAnagrams.decideAnagrams(inputStr1, inputStr2);
		assertEquals(testname, actual, expectedResult);
	}
}
