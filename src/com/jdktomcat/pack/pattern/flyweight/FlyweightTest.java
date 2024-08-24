package com.jdktomcat.pack.pattern.flyweight;

public class FlyweightTest {

    public static void main(String[] args) {
        Memory memory = MemoryFactory.getMemory(32);
        MemoryFactory.releaseMemory(memory.getId());
        MemoryFactory.getMemory(32);
    }
}
