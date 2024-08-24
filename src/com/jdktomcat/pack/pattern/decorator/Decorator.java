package com.jdktomcat.pack.pattern.decorator;

public class Decorator implements Sourceable {
    private Sourceable souce;

    public Decorator(Sourceable souce) {
        this.souce = souce;
    }

    @Override
    public void createComputer() {
        souce.createComputer();
        System.out.println("make system......");
    }
}
