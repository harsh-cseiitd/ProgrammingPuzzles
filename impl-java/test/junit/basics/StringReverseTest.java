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
import javap.basics.StringReverse;

import org.junit.Test;

public class StringReverseTest {

	@Test
	public void testStingIsomorphism() {
		testOneInstance("test1", "abcdefghijklmnopqrstuvwxyz", new StringBuilder("abcdefghijklmnopqrstuvwxyz").reverse().toString());
		testOneInstance("test2", "0123456789", new StringBuilder("0123456789").reverse().toString());
		testOneInstance("test2", "aaabbbcccdddeeffgghhiijjkkllooppmmnnbbhhss", new StringBuilder("aaabbbcccdddeeffgghhiijjkkllooppmmnnbbhhss").reverse().toString());
		testOneInstance("test3", "abcedf", new StringBuilder("abcedf").reverse().toString());
		testOneInstance("test4", "aaaaa", new StringBuilder("aaaaa").reverse().toString());
		testOneInstance("test5", "alphabet", new StringBuilder("alphabet").reverse().toString());
		testOneInstance("test6", "", new StringBuilder("").reverse().toString());
		testOneInstance("test7", "harsh vardhan", new StringBuilder("harsh vardhan").reverse().toString());
	}

	private void testOneInstance(String testname, String inputStr, String expectedResult) {
		String actual = StringReverse.reverse(inputStr);
		assertEquals(testname, expectedResult, actual);
	}
}
