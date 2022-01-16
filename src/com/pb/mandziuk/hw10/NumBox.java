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
    private int size = 0;

    public NumBox(int maxSize) {
        if (maxSize <=0){
            throw new IllegalArgumentException("Maximum size must be >0");
        }
     number = (T[]) new Number[maxSize];
    }

    public void add(T num){
if (size>= number.length){
    throw new NumBoxIsFullException("Size is " + size);
}
number[size]=num;
size++;
    }

    public T get (int index){
        if (index>=size){
            return null;
        }
        return number[index];
    }

    public int length (){
        return size;
    }

    public double average(){
           return sum()/size;
    }

public double sum (){
       if (size<1){
           throw new NumBoxIsEmptyException("Ii empty!");
       }
       double sum = 0;
       for (int i=0; i<size; i++){
           sum +=number[i].doubleValue();
}
    return sum;
}


public T max(){
        if (size<1){
            throw new NumBoxIsEmptyException("Is empty!");
        }
        double max = number[0].doubleValue();
        int maxIndex = 0;
    for(int n = 1; n < size; n++) {
        if (number[n].doubleValue() > max) {
            max = number[n].doubleValue();
            maxIndex = n;
        }
    }
    return number[maxIndex];
}
}



