package com.jdktomcat.pack.dsa.algorithm.leetcode.daily;

import java.util.*;

public class LeeCode {

    private static int split(int num1, int num2, int[] nums, int index, int op) {
        int[] newNums = new int[nums.length + 1];
        newNums[0] = num1;
        newNums[1] = num2;
        for (int i = 0; i < nums.length; ++i) {
            if (i != index) {
                newNums[i + 2] = nums[i];
            }
        }
        Arrays.sort(newNums);
        int target = newNums[newNums.length - 1];
        int min = target;
        if (op != 0) {
            for (int sub = 1; sub <= target / 2; ++sub) {
                min = Math.min(min, split(sub, target - sub, newNums, newNums.length - 1, op - 1));
            }
        }
        return min;
    }


    public static int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        int target = nums[index];
        int min = target;
        for (int sub = 1; sub <= target / 2; ++sub) {
            min = Math.min(min, split(sub, target - sub, nums, index, maxOperations - 1));
        }
        return min;
    }

    public static int minimumSizeNew(int[] nums, int maxOperations) {
        // 右侧数
        int right = 0;
        // 找出最大值
        for (int num : nums) {
            right = Math.max(right, num);
        }

        int left = 1;
        int pos = right;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 分裂次数
            int cnt = 0;
            for (int num : nums) {
                cnt += num / mid;
                if (num % mid == 0) cnt--;
            }
            if (cnt <= maxOperations) {
                right = mid - 1;
                pos = mid;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateNew(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int jump(int pointX, int pointY, int endX, int endY) {
        if (pointX == endX && pointY == endY) {
            return 1;
        } else if (pointX == endX) {
            return jump(pointX, pointY + 1, endX, endY);
        } else if (pointY == endY) {
            return jump(pointX + 1, pointY, endX, endY);
        }
        return jump(pointX + 1, pointY, endX, endY) + jump(pointX, pointY + 1, endX, endY);
    }

    public static int path(int m, int n) {
        return jump(1, 0, m - 1, n - 1) + jump(0, 1, m - 1, n - 1);
    }

    /**
     * 层级遍历
     *
     * @param node 根
     * @return 所有
     */
    public static List<List<Integer>> transfer(TreeNode node) {
        List<List<Integer>> levelDataList = new ArrayList<>();
        if (node == null) {
            return levelDataList;
        }
        if (node.left != null) {
            List<List<Integer>> leftNodeList = transfer(node.left);
            levelDataList.addAll(leftNodeList);
        }
        if (node.right != null) {
            List<List<Integer>> rightNodeList = transfer(node.right);
            int size = Math.min(levelDataList.size(), rightNodeList.size());
            int diffL = levelDataList.size() - size;
            int diffR = rightNodeList.size() - size;
            for (int index = 0; index < size; index++) {
                levelDataList.get(index + diffL).addAll(rightNodeList.get(index + diffR));
            }
            if (diffR > 0) {
                levelDataList.addAll(0, rightNodeList.subList(0, diffR));
            }
        }
        List<Integer> dataList = new ArrayList<>();
        dataList.add(node.val);
        levelDataList.add(dataList);
        return levelDataList;
    }

    public static String removeDuplicates(String s, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            Character top = deque.peek();
            int repeat = 1;
            while (top != null && top == ch) {
                repeat++;
                deque.pop();
                top = deque.peek();
            }
            while (repeat < k && --repeat >= 0) {
                deque.push(ch);
            }
        }
        Character[] chars = new Character[deque.size()];
        deque.toArray(chars);
        StringBuilder sub = new StringBuilder();
        for (Character character : chars) {
            sub.append(character);
        }
        if (sub.toString().equals(s)) {
            return s;
        }
        return removeDuplicates(sub.toString(), k);
    }

    public static int findLast(int n, int k) {
        if (n == 1) {
            return 1;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int index = 1; index <= n; index++) {
            deque.addLast(index);
        }
        int last = deque.peekFirst() == null ? -1 : deque.peekFirst();
        int cal = 0;
        while (deque.peekFirst() != null) {
            int num = deque.pollFirst();
            cal++;
            if (cal % k == 0) {
                cal = 0;
                last = num;
            } else {
                deque.addLast(num);
            }
        }
        return last;
    }


    private static int binSearch(int[] nums, int target, int start, int end) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            int midNum = nums[mid];
            if (target == midNum) {
                return mid;
            } else if (target > midNum) {
                return binSearch(nums, target, mid + 1, end);
            } else {
                return binSearch(nums, target, start, mid - 1);
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {

        return binSearch(nums, target, 0, nums.length - 1);


    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int k = 15;
//        System.out.println(containsNearbyDuplicate(nums, k));

//        System.out.println(path(7, 7));

//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
//        System.out.println(transfer(TreeNode.build(nums, 1)));

//        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        int[] nums = new int[]{5};
        int target = 5;
        System.out.println(search(nums, target));
    }
}
