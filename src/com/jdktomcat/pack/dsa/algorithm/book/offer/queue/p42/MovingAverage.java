package com.jdktomcat.pack.dsa.algorithm.book.offer.queue.p42;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口的平均值
 */
public class MovingAverage {

    private Queue<Integer> numbers;

    private int capacity;

    private int sum;

    public MovingAverage(int size) {
        numbers = new LinkedList<>();
        capacity = size;
    }

    public double next(int val) {
        numbers.offer(val);
        sum += val;
        if (numbers.size() > capacity) {
            sum -= numbers.poll();
        }
        return (double) sum / numbers.size();
    }

}
