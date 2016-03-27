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
import javap.basics.UniqueCharacterString;

import org.junit.Test;

public class UniqueCharacterStringTest {

	@Test
	public void testWithExtraStorage() {
		testOneInstance1("test1", "abcdefghijklmnopqrstuvwxyz", true);
		testOneInstance1("test2", "0123456789", true);
		testOneInstance1("test2", "aaabbbcccdddeeffgghhiijjkkllooppmmnnbbhhss", false);
		testOneInstance1("test3", "abcedf", true);
		testOneInstance1("test4", "78960", true);
		testOneInstance1("test5", "01234567890asdfghjkl", false);
		testOneInstance1("test6", " ", true);
		testOneInstance1("test7", "harsh vardhan", false);
	}
	
	@Test
	public void testWithoutExtraStorage() {
		testOneInstance2("test1", "abcdefghijklmnopqrstuvwxyz", true);
		testOneInstance2("test2", "0123456789", true);
		testOneInstance2("test2", "aaabbbcccdddeeffgghhiijjkkllooppmmnnbbhhss", false);
		testOneInstance2("test3", "abcedf", true);
		testOneInstance2("test4", "78960", true);
		testOneInstance2("test5", "01234567890asdfghjkl", false);
		testOneInstance2("test6", " ", true);
		testOneInstance2("test7", "harsh vardhan", false);
	}

	private void testOneInstance1(String testname, String inputStr, boolean expectedResult) {
		boolean actual = UniqueCharacterString.computeWithExtraStorage(inputStr);
		assertEquals(testname, expectedResult, actual);
	}
	
	private void testOneInstance2(String testname, String inputStr, boolean expectedResult) {
		boolean actual = UniqueCharacterString.computeWithOutExtraStorage(inputStr);
		assertEquals(testname, expectedResult, actual);
	}
}
