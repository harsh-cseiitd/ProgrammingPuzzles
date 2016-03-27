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
import javap.basics.StringSubstitution;

import org.junit.Test;

public class StringSubstitutionTest {

	@Test
	public void testStingSubstitution1() {
		testOneInstance1("test1", "AB CD EF GH", ' ', "X", "ABXCDXEFXGH");
		testOneInstance1("test2", " AB CD EF GH ", ' ', "X", "XABXCDXEFXGHX");
		testOneInstance1("test3", "A B C D E F G H", ' ', "Y", "AYBYCYDYEYFYGYH");
		testOneInstance1("test4", "  ", ' ', "Y", "YY");
		testOneInstance1("test5", "AB CD EF GH", ' ', "%20", "AB%20CD%20EF%20GH");
		testOneInstance1("test6", " AB CD EF GH ", ' ', "%20", "%20AB%20CD%20EF%20GH%20");
		testOneInstance1("test7", "A B C D E F G H", ' ', "%20", "A%20B%20C%20D%20E%20F%20G%20H");
	}
	
	@Test
	public void testStingSubstitution2() {
		testOneInstance2("test1", "AB CD EF GH", ' ', "X", "ABXCDXEFXGH");
		testOneInstance2("test2", " AB CD EF GH ", ' ', "X", "XABXCDXEFXGHX");
		testOneInstance2("test3", "A B C D E F G H", ' ', "Y", "AYBYCYDYEYFYGYH");
		testOneInstance2("test4", "  ", ' ', "Y", "YY");
		testOneInstance2("test5", "AB CD EF GH", ' ', "%20", "AB%20CD%20EF%20GH");
		testOneInstance2("test6", " AB CD EF GH ", ' ', "%20", "%20AB%20CD%20EF%20GH%20");
		testOneInstance2("test7", "A B C D E F G H", ' ', "%20", "A%20B%20C%20D%20E%20F%20G%20H");
	}

	private void testOneInstance1(String testname, String inputStr, char ch, String pattern, String expectedResult) {
		String actual = StringSubstitution.subsitute1(inputStr, ch, pattern);
		assertEquals(testname, expectedResult, actual);
	}
	
	private void testOneInstance2(String testname, String inputStr, char ch, String pattern, String expectedResult) {
		String actual = StringSubstitution.subsitute2(inputStr, ch, pattern);
		assertEquals(testname, expectedResult, actual);
	}
}
