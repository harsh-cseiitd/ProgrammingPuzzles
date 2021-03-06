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
import javap.basics.StringDuplicateRemoval;

import org.junit.Test;

public class StringDuplicateRemovalTest {

	@Test
	public void testStingDuplicateRemoval() {
		testOneInstance("test1", "abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz");
		testOneInstance("test2", "0123456789", "0123456789");
		testOneInstance("test3", "abcedf", "abcedf");
		testOneInstance("test4", "aaaaa", "a");
		testOneInstance("test5", "alphabet", "alphbet");
		testOneInstance("test6", "", "");
		testOneInstance("test7", "harsh vardhan", "hars vdn");
	}
	
	private void testOneInstance(String testname, String inputStr, String expectedResult) {
		String actual = StringDuplicateRemoval.getUniqueCharString(inputStr);
		assertEquals(testname, expectedResult, actual);
	}
}
