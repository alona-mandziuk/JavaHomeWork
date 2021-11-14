package com.pb.mandziuk.hw7;

public enum Size {
    XXS,
    XS,
    S,
    M,
    L;

    public void getDiscription (Size size) {
       if (size == XXS) {
           System.out.println("Дитячий розмір.");
       } else {
           System.out.println("Дорослий розмір.");
       }

   }

   public void getEurosize (Size size){
        switch (size){
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

   }
}

