package com.jdktomcat.pack.pattern.builder;

import java.util.logging.Logger;

public class ComputerConcreteBuilder implements ComputerBuilder {

    Computer computer;

    private static Logger logger = Logger.getLogger(ComputerConcreteBuilder.class.getName());

    public ComputerConcreteBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu() {
        logger.info("build cpu.....");
        computer.setCpu("8core");
    }

    @Override
    public void buildMemory() {
        logger.info("build memory.....");
        computer.setMemory("8g");
    }

    @Override
    public void buildDisk() {
        logger.info("build disk.....");
        computer.setDisk("1t");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
