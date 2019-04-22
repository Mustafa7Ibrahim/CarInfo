package com.example.car;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Car> cars ;


    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<Car>();
        cars.add(new Car("Volkswagen","Polo", "Hosam ", "7037685"));
        cars.add(new Car("Nissan","E200", "Nora ", "052658756"));
        cars.add(new Car("Mercedes","Z500", "Ali ", "985164387"));
        cars.add(new Car("Volkswagen","Polo", "Hosam ", "7037685"));
        cars.add(new Car("Nissan","E200", "Nora ", "052658756"));
        cars.add(new Car("Mercedes","Z500", "Ali ", "985164387"));
        cars.add(new Car("Volkswagen","Polo", "Hosam ", "7037685"));
        cars.add(new Car("Nissan","E200", "Nora ", "052658756"));
        cars.add(new Car("Mercedes","Z500", "Ali ", "985164387"));
        cars.add(new Car("Volkswagen","Polo", "Hosam ", "7037685"));
        cars.add(new Car("Nissan","E200", "Nora ", "052658756"));
        cars.add(new Car("Mercedes","Z500", "Ali ", "985164387"));

    }
}
