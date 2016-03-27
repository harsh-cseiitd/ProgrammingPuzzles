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
import javap.basics.StringIsomorphism;

import org.junit.Test;

public class StringIsomorphismTest {

	@Test
	public void testStingIsomorphism() {
		testHelper("test1", "abcdeeep", "xyzwrrrn", true);
		testHelper("test2", "aab", "xxy", true);
		testHelper("test3", "abcdef", "fedcba", true);
		testHelper("test4", "word", "xyzw", true);
		testHelper("test5", "1223334444", "abbcccdddd", true);
		testHelper("test6", "aaaabaaaa", "xxxxyzzzz", false);
		testHelper("test7", "kill", "bill", true);
		testHelper("test8", "India", "Pakistan", false);
	}
	
	private void testHelper(String testname, String inputStr1, String inputStr2, boolean expectedResult) {
		boolean actual = StringIsomorphism.decideIsomorphism(inputStr1, inputStr2);
		assertEquals(testname, expectedResult, actual);
	}

}
