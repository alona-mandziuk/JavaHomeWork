package com.pb.mandziuk.hw10;
// массив из объектов класса T, инициализировать массив в конструкторе.
//         - конструктор принимающий параметр - максимальную длину массива.
//         - метод void add(T num) добавляющий число в массив.
//         В случае если массив полон - выбросить исключение.
//         - метод T get(int index) возвращающий число по индексу.
//         - метод int length() возвращает текущее количество элементов.
//         - метод double average() - подсчет среднего арифметического среди элементов массива.
//         - метод double sum() - сумма всех элементов массива.
//         - метод T max() - максимальный элемент массива.
//         При подсчете воспользоваться тем, что у любого из объектов подклассов
//         Number есть методы intValue, doubleValue, floatValue и другие.

public class NumBox <T extends Number>{
   private  T[] number;

    public NumBox(int size) {
     number = (T[]) new Number[size];
    }

    void add(T num){

    }

    public T get (int index){
        return number[index];
    }

    public int length (){
        int i = 0;
        for (T n: number){
            if (n == null){
                break;
            }
            i++;
            if (i == number.length){
                System.out.println("no space");
                break;
            }
        }
        return i;
            }

    public double average(){
        double average = (sum()/length());
        return average;
    }

public double sum (){
        double sum = 0.0;
for (T n: number){
    if(n == null){
        sum+=0;
    } else sum+=n.doubleValue();
}
    return sum;
}


public T max(){
    T maxx = number[0];
    for(int n = 0; n < number.length; n++)
        if (number[n].doubleValue() > maxx.doubleValue()) {
            maxx = number[n];
        }
    return maxx;
}
}



