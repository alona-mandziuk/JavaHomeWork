package com.pb.mandziuk.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie(Size size, int prise, String colour) {
        super(size, prise, colour);
    }

    @Override
    public void dressMan() {
        System.out.println("Man wears tie: " + getInfo());

    }


}
