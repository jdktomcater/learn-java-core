package com.jdktomcat.pack.pattern.book.head_first.chapter04;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }


    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
