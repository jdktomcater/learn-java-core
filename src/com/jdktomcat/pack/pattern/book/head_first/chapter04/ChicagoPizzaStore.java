package com.jdktomcat.pack.pattern.book.head_first.chapter04;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if("cheese".equalsIgnoreCase(type)){
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}
