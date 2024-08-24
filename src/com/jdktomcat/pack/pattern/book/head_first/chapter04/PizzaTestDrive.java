package com.jdktomcat.pack.pattern.book.head_first.chapter04;

public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chStore = new ChicagoPizzaStore();

        Pizza nyPizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a "+nyPizza.getName()+". ");

        Pizza chPizza = chStore.orderPizza("cheese");
        System.out.println("Joel ordered a "+ chPizza.getName()+". ");
    }
}
