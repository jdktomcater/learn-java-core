package com.jdktomcat.pack.pattern.prototype;

public class Computer implements Cloneable {

    private String cpu;

    private String memory;

    private String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
