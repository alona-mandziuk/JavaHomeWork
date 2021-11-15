package com.pb.mandziuk.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{


    public Pants(Size size, int prise, String colour) {
        super(size, prise, colour);
    }


    @Override
    public void dressMan() {

    }

    @Override
    public void dressWomen() {

    }

    @Override
    public String toString() {
        return "Pants{" +
                "size=" + size +
                ", prise=" + prise +
                ", colour='" + colour + '\'' +
                '}';
    }
}
