package com.jdktomcat.pack.dsa.algorithm.book.offer.queue.p43;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最近请求次数
 */
public class RecentAverage {

    private final Queue<Integer> times;

    private final int windowSize;

    public RecentAverage() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        times.offer(t);
        while (!times.isEmpty() && times.peek() + windowSize < t) {
            times.poll();
        }
        return times.size();
    }
}
