package com.jdktomcat.pack.pattern.iterator;

public class IteratorTest {

    public static void main(String[] args) {
        Collection collection = new ListCollection();
        collection.add("object1");
        collection.add("object2");
        collection.add("object3");
        collection.add("object4");
        collection.add("object5");

        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
