package com.jdktomcat.pack.pattern.builder;

public class ComputerDirector {

    public Computer constructComputer(ComputerBuilder computerBuilder) {
        computerBuilder.buildCpu();
        computerBuilder.buildDisk();
        computerBuilder.buildMemory();
        return computerBuilder.buildComputer();
    }
}
