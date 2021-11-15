package com.pb.mandziuk.hw7;

public interface WomenClothes {
    void dressWomen();

    Tshirt wTshirt = new Tshirt(Size.XS, 10, "white");
    Skirt wSkirt1 = new Skirt(Size.M, 60, "gray-blue");
    Skirt wSkirt2 = new Skirt(Size.XXS, 25, "light-blue");
    Pants wPants1 = new Pants(Size.XXS, 18, "jeens");
    Pants wPants2 = new Pants(Size.S, 70, "ultra-black");

    Clothes[] womenClothes = new Clothes[] {wPants1,wPants2,wSkirt1,wSkirt2,wTshirt};
}
