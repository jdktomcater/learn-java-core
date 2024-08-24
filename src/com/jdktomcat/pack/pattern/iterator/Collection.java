package com.jdktomcat.pack.pattern.iterator;

public interface Collection {

    Iterator iterator();

    Object get(int i);

    boolean add(Object object);

    int size();
}
