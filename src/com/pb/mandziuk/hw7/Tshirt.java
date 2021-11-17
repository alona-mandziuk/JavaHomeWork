package com.pb.mandziuk.hw7;

class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(Size size, int prise, String colour) {
        super(size, prise, colour);
    }


    @Override
    public void dressMan() {
        System.out.println("Man wears t-shirt: " + getInfo());
    }

    @Override
    public void dressWomen() {
        System.out.println("Women wears t-shirt: " + getInfo());

    }


}




