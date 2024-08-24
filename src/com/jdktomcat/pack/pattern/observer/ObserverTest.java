package com.jdktomcat.pack.pattern.observer;

public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();
        Observer observer4 = new ConcreteObserver();
        subject.add(observer);
        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);
        subject.add(observer4);
        subject.notifyObserver("hello tq ");
    }
}
