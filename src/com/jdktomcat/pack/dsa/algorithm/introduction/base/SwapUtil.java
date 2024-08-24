package com.jdktomcat.pack.dsa.algorithm.introduction.base;

public class SwapUtil {

	/**
	 * swap data
	 * 
	 * @param i
	 * @param j
	 * @param dataArray
	 */
	public static <T> void swap(int i, int j, T[] dataArray) {
		if (dataArray == null || i >= dataArray.length || i < 0 || j >= dataArray.length || j < 0) {
			return;
		}
		T temp = dataArray[i];
		dataArray[i] = dataArray[j];
		dataArray[j] = temp;
	}
}
