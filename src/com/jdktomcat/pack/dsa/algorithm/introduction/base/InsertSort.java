package com.jdktomcat.pack.dsa.algorithm.introduction.base;

public class InsertSort {
	/**
	 * insert sort algorithm
	 * 
	 * @param dataWrappers target data array
	 */
	public static void sort(DataWrapper[] dataWrappers) {
		if (dataWrappers != null && dataWrappers.length > 1) {
			for (int i = 1; i < dataWrappers.length; i++) {
				int j = i;
				while (j > 0 && (dataWrappers[j].getValue() < dataWrappers[j-1].getValue())) {
					SwapUtil.swap(j, j - 1, dataWrappers);
					j--;
				}
			}
		}
	}
}
