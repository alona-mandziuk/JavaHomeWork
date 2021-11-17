package com.pb.mandziuk.hw7;

public class Skirt extends Clothes implements WomenClothes {

    public Skirt(Size size, int prise, String colour) {
        super(size, prise, colour);
    }

    @Override
    public void dressWomen() {
        System.out.println("Woman wears skirt: " + getInfo());

    }


}
