/*
 * Copyright (C) 2015 Harsh Vardhan
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

/*
 * Problem: Create a list which hashes each unique input character to
 * a unique index in list. This data structure will be useful to store
 * frequencies of characters in a java string.
 */
import java.util.*;

public class HashCharacterList {

	private int[] list;
	private int capacity;

	public HashCharacterList() {
		this.capacity = (Character.MAX_VALUE - Character.MIN_VALUE + 1);
		this.list = new int[this.capacity];
	}

	public HashCharacterList(int cap) {
		this.capacity = cap;
		this.list = new int[this.capacity];
	}	

	public boolean exist(char ch) {
		int index = getIndex(ch);
		if (list[index] == 0) {
			return true;
		}
		return false;
	}

	public void incrementCount(char ch) {
		int index = getIndex(ch);
		list[index] = list[index] + 1;
	}

	public void decrementCount(char ch) {
		int index = getIndex(ch);
		if (list[index] > 0) {
			list[index] = list[index] - 1;
		}
	}

	public int getCount(char ch) {
		int index = getIndex(ch);
		return list[index] ;
	}

	private int getIndex(char ch) {
		int numeric = Character.getNumericValue(ch);
		return (numeric - Character.MIN_VALUE);
	}
}
