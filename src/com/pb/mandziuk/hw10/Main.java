package com.pb.mandziuk.hw10;
//Создать класс Main с методом main где протестировать полученный класс на примере
//        NumBox<Float> и NumBox<Integer>.



public class Main {
    public static void main (String [] args) {
        NumBox<Float> floatNumBox = new NumBox<>(6);
            floatNumBox.add(5.5f);
            floatNumBox.add(1.4f);
            floatNumBox.add(7.1f);
            floatNumBox.add(8.6f);
            print(floatNumBox);

            NumBox <Integer> integerNumBox = new NumBox<>(7);
            integerNumBox.add(9);
            integerNumBox.add(-5);
            integerNumBox.add(0);
            integerNumBox.add(10);
            integerNumBox.add(4);
            print(integerNumBox);}

    private static void print (NumBox<?> numBox){
        int length = numBox.length();
        System.out.println();
        for (int i=0; i<length; i++){
            System.out.println(numBox.get(i) + " ");
        }
        System.out.println();
        System.out.println("Summ: " + numBox.sum());
        System.out.println("Average: " + numBox.average());
        System.out.println("Maximum value: " + numBox.max());
    }
}








