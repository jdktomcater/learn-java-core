package com.jdktomcat.pack.pattern.adapter;

public class ObjectAdapter implements Targetable {

    private Source source;

    public ObjectAdapter(Source source) {
        this.source = source;
    }

    @Override
    public void editTextFile() {
        this.source.editTextFile();
    }

    @Override
    public void editWordFile() {
        System.out.println("a word file editing.....");
    }
}
