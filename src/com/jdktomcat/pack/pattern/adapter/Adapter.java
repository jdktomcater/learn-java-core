package com.jdktomcat.pack.pattern.adapter;

public class Adapter extends Source implements Targetable {

    @Override
    public void editTextFile() {
        super.editTextFile();
    }

    @Override
    public void editWordFile() {
        System.out.println("a word file editing.....");
    }
}
