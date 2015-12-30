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
 * Problem: Implement a storage efficient data structure which can store presence 
 * of a character in java string. Possible alphabet of input string instance may,
 * vary it may be set of ASCII, ASCII or Unicode. So consumption of storage should
 * be proportional to alphabet of input sting instance.
 */

package org.harshv.javap.utils;

import java.util.*;

public class CharPresenceMarkList {
	private ArrayList<Integer> list;
	private int capacity;

	private class Position {

		private int bucket;
		private int bitPosition;

		public Position() {
			this(0,0);
		}

		public Position(int b, int bit) {
			this.bucket = b;
			this.bitPosition = bit;
		}

		public int getBucket() {
			return this.bucket;
		}

		public int getBitPosition() {
			return this.bitPosition;
		}
	}

	private Position getPosition(char ch) {
		int bucket = Character.hashCode(ch) / (Integer.SIZE - 1);
		int bitPos = Character.hashCode(ch) % (Integer.SIZE - 1);
		return new Position(bucket, bitPos);
	}

	public CharPresenceMarkList() {
		Integer size = new Integer(Character.hashCode(Character.MAX_VALUE) - Character.hashCode(Character.MIN_VALUE) + 1);
		this.capacity = new Double(Math.ceil(size.doubleValue() / Integer.SIZE)).intValue();
		this.list = new ArrayList<Integer>(this.capacity);
		for (int i = 0; i < this.capacity ; i++) {
			this.list.add(0);
		}
	}

	public CharPresenceMarkList(int cap) {
		this.capacity = cap;
		this.list = new ArrayList<Integer>(this.capacity);
		for (int i = 0; i < this.capacity ; i++) {
			this.list.add(0);
		}
	}	

	public boolean exist(char ch) {
		boolean charMarked = false;
		Position pos   = getPosition(ch);
		if(pos.getBucket() < this.capacity) {
			int element = this.list.get(pos.getBucket());
			int result  = element & (1 << pos.getBitPosition());
			if (result > 0) {
				charMarked = true;
			}	
		}
		return charMarked;
	}

	public void mark(char ch) {
		Position pos = getPosition(ch);
		if(pos.getBucket() >= this.capacity) {
			int newCapacity = pos.getBucket() + 4;
			this.list.ensureCapacity(newCapacity);
			for (int i = this.capacity ; i <= newCapacity ; i++) {
				this.list.add(0);
			}
			this.capacity = newCapacity;
		}
		int element = this.list.get(pos.getBucket());
		element = element | (1 << pos.getBitPosition());
		this.list.set(pos.getBucket(), element);
	}

	public void unmark(char ch) {
		Position pos = getPosition(ch);
		if(pos.getBucket() < this.capacity) {
			int element = this.list.get(pos.getBucket());
			element = element & (~(1 << pos.getBitPosition()));
			this.list.set(pos.getBucket(), element);
		}	
	}
}
