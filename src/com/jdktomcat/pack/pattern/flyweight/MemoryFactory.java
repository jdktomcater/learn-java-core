package com.jdktomcat.pack.pattern.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryFactory {

    private static List<Memory> memoryList = new ArrayList<>();

    public static Memory getMemory(int size) {
        Memory target = null;
        for (Memory memory : memoryList) {
            if (memory.getSize() == size && !memory.isUsed()) {
                memory.setUsed(true);
                target = memory;
                break;
            }
        }
        if (target == null) {
            target = new Memory(size, false, UUID.randomUUID().toString());
            memoryList.add(target);
        }
        return target;
    }

    public static void releaseMemory(String id) {
        for (Memory memory : memoryList) {
            if (memory.getId().equalsIgnoreCase(id)) {
                memory.setUsed(true);
                break;
            }
        }
    }
}
