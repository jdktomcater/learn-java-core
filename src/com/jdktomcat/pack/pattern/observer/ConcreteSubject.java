package com.jdktomcat.pack.pattern.observer;

public class ConcreteSubject extends Subject {
    @Override
    protected void notifyObserver(String message) {
        for (Observer observer : observers) {
            observer.dataChange(message);
        }
    }
}
