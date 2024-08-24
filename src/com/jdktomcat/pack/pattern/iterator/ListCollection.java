package com.jdktomcat.pack.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class ListCollection implements Collection {

    List<Object> list = new ArrayList<>();

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public boolean add(Object object) {
        return list.add(object);
    }

    @Override
    public int size() {
        return list.size();
    }
}
