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
import javap.basics.BasicStringCompression;

import org.junit.Test;

public class BasicStringCompressionTest {

	@Test
	public void testStingCompression() {
		testOneInstance("test1", "xxyyyyzeepppppppp", "x2y4z1e2p8");
		testOneInstance("test2", "xyzabcef", "xyzabcef");
		testOneInstance("test3", "abcdef", "abcdef");
		testOneInstance("test4", "aaaaaaaabb", "a8b2");
		testOneInstance("test5", "abbbbbbbbbbc", "a1b10c1");
		testOneInstance("test6", "abcdeeeeeeeeeeee", "a1b1c1d1e12");
		testOneInstance("test7", "aaaaaaaabcdaaaaaaaa", "a8b1c1d1a8");
	}
	
	private void testOneInstance(String name, String input, String expectedResult) {
		String actual = BasicStringCompression.getBasicCompressedString(input);
		assertEquals(name, expectedResult, actual);
	}
}
