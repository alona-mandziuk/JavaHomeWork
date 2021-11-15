package com.pb.mandziuk.hw7;

public class Skirt extends Clothes implements WomenClothes {

    public Skirt(Size size, int prise, String colour) {
        super(size, prise, colour);
    }

    @Override
    public void dressWomen() {

    }

    @Override
    public String toString() {
        return "Skirt{" +
                "size=" + size +
                ", prise=" + prise +
                ", colour='" + colour + '\'' +
                '}';
    }
}
