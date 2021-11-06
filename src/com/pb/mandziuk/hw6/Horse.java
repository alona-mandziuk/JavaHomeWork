package com.pb.mandziuk.hw6;

import java.util.Objects;

public class Horse extends Animal {
    String food = " sugar ";
    String location = " green lawn ";

    public Horse() {
        super("Horse named JONAH", " sugar  ", "  green lawn");
    }

    @Override
    public void makeNoise () {
          super.makeNoise();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void sleep() {
        super.sleep();
    }

    @Override
    public String toString() {
        return "Horse{" +
                "food='" + food + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(food, horse.food) && Objects.equals(location, horse.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }

}
