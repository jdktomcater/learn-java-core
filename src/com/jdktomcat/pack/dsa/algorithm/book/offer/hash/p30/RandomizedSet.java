package com.jdktomcat.pack.dsa.algorithm.book.offer.hash.p30;

import com.jdktomcat.pack.util.jdk8.HashMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * 插入、删除和随机访问都是o(1)的容器
 */
public class RandomizedSet {
    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> numbers;

    public RandomizedSet() {
        numToLocation = new HashMap<>();
        numbers = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }
        numToLocation.put(val, numbers.size());
        numbers.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }
        int location = numToLocation.get(val);
        numToLocation.put(numbers.get(numbers.size() - 1), location);
        numToLocation.remove(val);
        numbers.set(location, numToLocation.get(numbers.size() - 1));
        numbers.remove(numbers.size() - 1);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int r = random.nextInt(numbers.size());
        return numbers.get(r);
    }

}
