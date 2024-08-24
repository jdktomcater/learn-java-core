package com.jdktomcat.pack.pattern.adapter;

public class SourceSub1 extends AbstractAdapter {
    @Override
    public void editTextFile() {
        super.editTextFile();
        System.out.println("a txt file editing.....");
    }
}
