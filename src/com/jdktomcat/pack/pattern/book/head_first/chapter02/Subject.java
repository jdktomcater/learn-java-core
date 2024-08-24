package com.jdktomcat.pack.pattern.book.head_first.chapter02;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
