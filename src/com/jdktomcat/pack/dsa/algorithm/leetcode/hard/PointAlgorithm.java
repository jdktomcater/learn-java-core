package com.jdktomcat.pack.dsa.algorithm.leetcode.hard;

public class PointAlgorithm {
	private static final Integer X_MAX = 100;

	private static final Integer Y_MAX = 100;

	/**
	 * 是否为栅栏点
	 * 
	 * @param barrier 栅栏点集合
	 * @param target      点
	 * @return true:是 false:否
	 */
	private static boolean isBarrierPoint(int[][] barrier, int[] target) {
		for (int[] point : barrier) {
			if (point[0] == target[0] && point[1] == target[1]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否能夠組成封閉
	 * 
	 * @param barrier    柵欄點
	 * @param startPoint 開始點
	 * @param point     目標點
	 * @return true:是 false:否
	 */
	private static boolean isCyclePoint(int[][] barrier, int[] startPoint, int[] point) {
		if (startPoint[0] == point[0] && startPoint[1] == point[1]) {
			return true;
		}
		if (isBarrierPoint(barrier, point)) {
			if (point[0] != 0 && point[0] != X_MAX && point[1] != 0 && point[1] != Y_MAX) {
				return isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] + 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] + 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] + 1 });

			} else if (point[0] != 0 && point[0] != X_MAX && point[1] == Y_MAX) {
				return isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] - 1 });
			} else if (point[0] != 0 && point[0] != X_MAX && point[1] == 0) {
				return isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] + 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] + 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] + 1 });

			} else if (point[0] == X_MAX && point[1] != 0 && point[1] != Y_MAX) {
				return isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] + 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] - 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] + 1 });
			} else if (point[0] == 0 && point[1] != 0 && point[1] != Y_MAX) {
				return isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] + 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0] + 1, point[1] })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] - 1 })
						|| isCyclePoint(barrier, startPoint, new int[] { point[0], point[1] + 1 });
			}
		}
		return false;
	}

	/**
	 * 两点是否可达
	 * 
	 * @param barrier 屏障点
	 * @param source  起始点
	 * @param target  终点
	 * @return true:可达 false:不可达
	 */
	private static boolean isCanReach(int[][] barrier, int[] source, int[] target) {
		return isCloseable(barrier);
	}

	/**
	 * 是否为封闭空间
	 * 
	 * @param barrier 栅栏点
	 * @return true:是 false:否
	 */
	private static boolean isCloseable(int[][] barrier) {
		int length = barrier.length;
		if (length > 1) {
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (i != j) {
						if (isCyclePoint(barrier, barrier[i], barrier[j])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] barrier = new int[][] { { 2, 3 }, { 0, 1 } };
		int[] source = new int[] { 4, 7 };
		int[] target = new int[] { 99, 99 };
		System.out.println(isCanReach(barrier, source, target));
	}
}
