package com.jdktomcat.pack.dsa.algorithm.introduction.base;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		// 测试输入测试
		DataWrapper[] dataWrappers = new DataWrapper[] {
			new DataWrapper(31),new DataWrapper(41),
			new DataWrapper(59),new DataWrapper(26),
			new DataWrapper(41),new DataWrapper(58),
			new DataWrapper(41),new DataWrapper(41),
			new DataWrapper(31),new DataWrapper(41),
			new DataWrapper(31),new DataWrapper(41)
		};
		System.out.println("Before sort:"+Arrays.toString(dataWrappers));
		InsertSort.sort(dataWrappers);
		System.out.println("After sort:"+Arrays.toString(dataWrappers));
	}

}
