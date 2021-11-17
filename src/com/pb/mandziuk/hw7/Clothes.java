package com.pb.mandziuk.hw7;

public abstract class Clothes {
   protected Size size;
   protected  int prise;
   protected String colour;

    public Clothes(Size size, int prise, String colour) {
        this.size = size;
        this.prise = prise;
        this.colour = colour;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getInfo () {
        return " size " + size.name() + " (" + size.getDescription() + " " + size.getEurosize() + ") colour - " +
                colour + ", " + " prise: " + prise;
    }
}
