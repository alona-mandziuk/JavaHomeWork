package com.pb.mandziuk.hw7;

import java.util.Arrays;

public class Atelier {

    @Override
    public String toString() {
        return "Atelier{}";
    }

    public static void main(String[] args) {

          Clothes[] clothes = new Clothes[]{ManClothes.manTie1, ManClothes.manTie2, ManClothes.manTshirt,
                ManClothes.manPants, WomenClothes.wPants1, WomenClothes.wPants2, WomenClothes.wTshirt,
                WomenClothes.wSkirt1, WomenClothes.wSkirt1};

        System.out.println(ManClothes.manPants);
        System.out.println(ManClothes.manTie1);
        System.out.println(ManClothes.manTie2);

    }

    public static void dressMan(Clothes [] clothes) {

            for (Clothes cloth: clothes) {
                if (cloth instanceof ManClothes) {
                    System.out.println("Male clothes: "  + ManClothes.manPants + ManClothes.manTshirt
                            + ManClothes.manTie1 + ManClothes.manTie2);
                }
            }
        }

    public static void dressWomen(Clothes [] clothes) {
        for (Clothes cloth: clothes) {
            if (cloth instanceof WomenClothes){
                System.out.println("Female clothes: " + WomenClothes.womenClothes);
            }
        }
    }
/*static void dressMan(Clothes [] clothes) {
    System.out.println("Male clothes: ");
    for (Clothes cloth: clothes) {
        if (cloth instanceof ManClothes) {
            ((ManClothes) cloth).dressMan();
        }
    }
}*/

    }
