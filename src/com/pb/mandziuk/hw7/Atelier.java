package com.pb.mandziuk.hw7;

import java.util.Arrays;

public class Atelier {

    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[]{

        new Tshirt(Size.XS, 10, "white"),
        new Tshirt(Size.L, 11, "black"),
        new Skirt(Size.M, 60, "gray-blue"),
        new Skirt(Size.XXS, 25, "light-blue"),
        new Pants(Size.XXS, 18, "jeens"),
        new Pants(Size.S, 70, "ultra-black"),
        new Pants(Size.L, 84, "beige"),
        new Tie(Size.S, 15, "green"),
        new Tie(Size.M, 11, "black-in-white-stripes")};

        dressMan(clothes);
        System.out.println("----------------");
        dressWomen(clothes);




    }

    static void dressMan(Clothes [] clothes) {
        for (Clothes cloth: clothes) {
        if (cloth instanceof ManClothes) {
            ((ManClothes) cloth).dressMan();
        }
    }
}

    static void dressWomen(Clothes [] clothes) {
        for (Clothes cloth: clothes) {
            if (cloth instanceof WomenClothes) {
                ((WomenClothes) cloth).dressWomen();
            }
        }
    }
    }
