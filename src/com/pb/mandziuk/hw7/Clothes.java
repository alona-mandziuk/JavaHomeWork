package com.pb.mandziuk.hw7;

public abstract class Clothes {
    Size size;
    public  int prise;
    public  String colour;

    public Clothes(Size size, int prise, String colour) {
        this.size = size;
        this.prise = prise;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "size=" + size +
                ", prise=" + prise +
                ", colour='" + colour + '\'' +
                '}';
    }
}
