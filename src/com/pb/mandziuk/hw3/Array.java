package com.pb.mandziuk.hw3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Array {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Заповніть масив із 10 чисел");
        int mas[] = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = input.nextInt();
        }

        System.out.println("Ваш масив");
        for (int i=0;i < mas.length;i++){
            System.out.print(mas[i]+ " ");
        }
        System.out.println();

        int num = 0;
        for (int i=0 ; i< mas.length; i++){
            if (mas[i]>0 ){
                num++;
            }
        }
        System.out.println("Кількість елементів більше 0  =  "+ num);

        int total = IntStream.of(mas).sum();
        System.out.println("Сума чисел: " + (total));


        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }
            }
        }
        System.out.println("Сортування бульбашковим методом: " + Arrays.toString(mas));

    }

    }

