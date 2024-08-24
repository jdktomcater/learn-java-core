package com.jdktomcat.pack.pattern.builder;

import java.util.logging.Logger;

public class BuilderPatternTest {

    private static Logger logger = Logger.getLogger(BuilderPatternTest.class.getName());


    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        ComputerBuilder computerBuilder = new ComputerConcreteBuilder();
        Computer computer = computerDirector.constructComputer(computerBuilder);

        logger.info(computer.getCpu());
        logger.info(computer.getDisk());
        logger.info(computer.getMemory());


    }
}
