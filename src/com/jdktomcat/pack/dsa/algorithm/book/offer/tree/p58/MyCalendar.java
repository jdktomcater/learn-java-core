package com.jdktomcat.pack.dsa.algorithm.book.offer.tree.p58;

import java.util.Map;
import java.util.TreeMap;

/**
 * 日程表
 */
public class MyCalendar {

    private final TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    /**
     * 预定
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return true:成功 false:失败
     */
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        if (event != null && event.getValue() > start) {
            return false;
        }
        event = events.ceilingEntry(start);
        if (event != null && event.getKey() < end) {
            return false;
        }
        events.put(start, end);
        return true;
    }
}
