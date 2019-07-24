package com.gym.entity;

import java.util.Objects;

public class Subscription extends BaseEntity{

    private int numberVisit;

    private double price;

    public Subscription(int numberVisit, double price) {
        this.numberVisit = numberVisit;
        this.price = price;
    }

    public Subscription(){}

    public int getNumberVisit() {
        return numberVisit;
    }

    public void setNumberVisit(int numberVisit) {
        this.numberVisit = numberVisit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return numberVisit == that.numberVisit &&
                Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberVisit, price);
    }


}
