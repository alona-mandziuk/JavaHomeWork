package com.pb.mandziuk.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{


    public Pants(Size size, int prise, String colour) {
        super(size, prise, colour);
    }


    @Override
    public void dressMan() {
        System.out.println("Man wears pants: " + getInfo());

    }

    @Override
    public void dressWomen() {
        System.out.println("Woman wears pants: " + getInfo());

    }


}
