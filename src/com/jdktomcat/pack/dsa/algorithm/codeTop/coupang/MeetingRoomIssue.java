package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.*;

/**
 * 会议室相关问题（考察优先队列）
 */
public class MeetingRoomIssue {

    /**
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
     * 返回 所需会议室的最小数量
     *
     * @param intervals 会议信息
     * @return 会议室数量
     */
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        Map<Integer, List<int[]>> meetMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            List<int[]> meetList = new ArrayList<>();
            meetList.add(intervals[i]);
            meetMap.put(i, meetList);
        }
        for (int i = 0; i < intervals.length - 1; i++) {
            List<int[]> meetList = meetMap.get(i);
            if (meetList == null || meetList.isEmpty()) {
                continue;
            }
            for (int j = i + 1; j < intervals.length; j++) {
                List<int[]> subMeetList = meetMap.get(j);
                if (!(subMeetList == null || subMeetList.size() != 1)) {
                    boolean flag = true;
                    for (int in = 0; in < meetList.size() && flag; in++) {
                        int[] ints = meetList.get(in);
                        if (intervals[j][0] < ints[1]) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        meetList.add(intervals[j]);
                        meetMap.remove(j);
                    }
                }
                meetMap.put(i, meetList);
            }
        }
        return meetMap.size();
    }

    /**
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
     * 返回 所需会议室的最小数量（优先队列）
     *
     * @param intervals 会议信息
     * @return 会议室数量
     */
    public static int minMeetingRoomsL0(int[][] intervals) {
        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
        // Sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // Add the first meeting
        allocator.add(intervals[0][1]);
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (!allocator.isEmpty() && intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

    /**
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
     * 返回 所需会议室的最小数量有序化
     *
     * @param intervals 会议信息
     * @return 会议室数量
     */
    public static int minMeetingRoomsL1(int[][] intervals) {
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(end, Comparator.comparingInt(a -> a));
        // Sort the intervals by start time
        Arrays.sort(start, Comparator.comparingInt(a -> a));
        // The two pointers in the algorithm: e_ptr and s_ptr.
        int startPointer = 0, endPointer = 0;
        // Variables to keep track of maximum number of rooms used.
        int usedRooms = 0;
        // Iterate over intervals.
        while (startPointer < intervals.length) {
            // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }
            // We do this irrespective of whether a room frees up or not.
            // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms
            usedRooms += 1;
            startPointer += 1;
        }
        return usedRooms;
    }

    public static void main(String[] args) {
        int[][] ints = {{15, 16}, {10, 15}, {16, 25}};
        System.out.println(minMeetingRooms(ints));
    }

}
