package com.pb.mandziuk.hw6;

import java.util.Objects;

public class Dog extends Animal{
    String food = " meatballs ";
    String location = " his master`s lap ";

    public Dog() {
        super("Dog LUCKY", " meatballs ", "  his master`s lap");
    }

    @Override
    public void makeNoise () {
        System.out.println(getName() + " barks");
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
        return "Dog{" +
                "food='" + food + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(food, dog.food) && Objects.equals(location, dog.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }

}
