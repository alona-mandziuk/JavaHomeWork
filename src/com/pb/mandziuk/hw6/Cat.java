package com.pb.mandziuk.hw6;

import java.util.Objects;

public class Cat extends Animal{

    String food = " milk ";
    String location = " in that cushion ";

    public Cat() {
        super("Cat PUSHOK" , " milk ", "  that cushion");
    }

    @Override
    public void makeNoise () {
        System.out.println(getName() + " makes MIU-MIU");
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
        return "Cat{" +
                "food='" + food + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(food, cat.food) && Objects.equals(location, cat.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }
}
