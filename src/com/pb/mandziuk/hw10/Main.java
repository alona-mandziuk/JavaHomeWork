package com.pb.mandziuk.hw10;
//Создать класс Main с методом main где протестировать полученный класс на примере
//        NumBox<Float> и NumBox<Integer>.

public class Main {
    public static void main (String [] args) throws Exception {
        NumBox<java.lang.Float> floatNumBox = new NumBox<>(3);
        try {
            floatNumBox.add(5.5f);
            floatNumBox.add(1.4f);
            floatNumBox.add(7.1f);

        }catch (Exception e){
            System.out.println("No space in array");
            try {
                float float0 = floatNumBox.get(0);
                float float1 = floatNumBox.get(1);
                float float2 = floatNumBox.get(2);
                System.out.println(float0);
                System.out.println(float1);
                System.out.println(float2);
            }finally {
                System.out.println("Get array index.");
            }
        }
        System.out.println(floatNumBox.length());
        System.out.println(floatNumBox.sum());
        System.out.println(floatNumBox.max());




    }
}
