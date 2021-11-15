package com.pb.mandziuk.hw7;

class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt(Size size, int prise, String colour) {
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
        return "Tshirt{" +
                "size=" + size +
                ", prise=" + prise +
                ", colour='" + colour + '\'' +
                '}';
    }
}




