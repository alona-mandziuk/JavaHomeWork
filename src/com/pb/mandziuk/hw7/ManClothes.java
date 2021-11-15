package com.pb.mandziuk.hw7;

public interface ManClothes {

     Tshirt manTshirt = new Tshirt(Size.L, 11, "black");
     Tie manTie1 = new Tie(Size.S, 15, "green");
     Tie manTie2 = new Tie(Size.M, 11, "black-in-white-stripes");
     Pants manPants = new Pants(Size.L, 84, "beige");

    Clothes[] manClothes = new Clothes[] {manTie1,manTie2,manPants,manTshirt};

     void dressMan ();

     }


