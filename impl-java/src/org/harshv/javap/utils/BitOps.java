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
 * Problem: Implement a utility wrapper class for bitwise operations.
 */

package org.harshv.javap.utils;

import java.util.*;

public class BitOps {
	
	public static boolean isNegative(int num) {
		int bitmask = (1 << (Integer.SIZE - 1));
		if ((bitmask & num) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isEven(int num) {
		int bitmask = 1;
		if ((bitmask & num ) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBitSet(int num, int bitPosition) {
		int bitmask = (1 << bitPosition);
		if ((bitmask & num) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isPowerOfTwo(int num) {
		int bitmask = (num - 1);
		if (num == 0) {
			return false;
		} else if ((num & bitmask) > 0) {
			return false;
		}
		return true;
	}
	
	public static int setBit(int num, int bitPosition) {
		int bitmask = (1 << bitPosition);
		return (bitmask | num);
	}
	
	public static int unsetBit(int num, int bitPosition) {
		int bitmask = ~(1 << bitPosition);
		return (bitmask & num);
	}
	
	public static int toggleBit(int num, int bitPosition) {
		int bitmask = (1 << bitPosition);
		return (bitmask ^ num);
	}
}
