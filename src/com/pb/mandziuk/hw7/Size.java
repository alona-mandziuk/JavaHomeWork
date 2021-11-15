package com.pb.mandziuk.hw7;

public enum Size {
    XXS ("Kid size", "32"),
    XS ("Adult size", "34"),
    S ("Adult size", "36"),
    M ("Adult size", "38"),
    L("Adult size", "40");

    String Description;
    String Eurosize;




/*    public void getDescription (Size size){
        if (size == XXS) {
            System.out.println("Kid size");
        } else {
            System.out.println("Adult size");
        }

    }

    public void getEurosize (Size size){
        switch (size) {
            case XXS:
                System.out.println("32");
                break;
            case XS:
                System.out.println("34");
                break;
            case S:
                System.out.println("36");
                break;
            case M:
                System.out.println("38");
                break;
            case L:
                System.out.println("40");
                break;
        }

    }*/

    @Override
    public String toString() {
        return "Size{" +
                "Description='" + Description + '\'' +
                ", Eurosize='" + Eurosize + '\'' +
                '}';
    }

    Size(String Description, String Eurosize) {
        this.Description = Description;
    this.Eurosize = Eurosize;}


    }





