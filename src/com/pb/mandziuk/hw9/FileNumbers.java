package com.pb.mandziuk.hw9;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


//В пакете hw9 создать класс FileNumbers.
//        В нем создать методы:
////        - createNumbersFile - создает текстовый файл "numbers.txt"
// заполненный случайными целыми числами от 1 до 99. 10 строк и по 10 чисел в каждой строке.
// Числа разделять пробелами.
//        - createOddNumbersFile - читает файл "numbers.txt", и создает на основе него новый
//        файл "odd-numbers.txt" в который входят все числа из "numbers.txt"
//        только все четные заменены на 0.
//        В методе main продемонстрировать работу методов createNumbersFile и createOddNumbersFile.
public class FileNumbers {

    public static Path path = Paths.get("NumbersFile.txt");

    public static void createNumbersFile() throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(path)){
           int [][] array = new int[10][10];
            for (int i = 0; i < array.length; i++, System.out.println(), writer.newLine()){
                for (int j = 0; j< array.length; j++){
                    array [i][j]= ((int) (Math.random()*99+1));
                    System.out.print(array[i][j] + " ");

                    writer.write(array[i][j] + " ");
                }
            }
        }catch (IOException e){System.out.println("Error" + e);}
        }



public static void createOddNumbersFile() throws IOException {
        try (Scanner reader = new Scanner(path)) {
            PrintWriter writer2 = new PrintWriter(new File("odd-numbers.txt"));
            System.out.println("________________________");
            System.out.println("New matrix with changed numbers:");
            while (reader.hasNextLine()) {
                Scanner scanner = new Scanner(reader.nextLine());
                while (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    if (num % 2 == 0) {
                        System.out.print("0");
                        num = 0;
                    } else
                        System.out.println(num + " ");
                    writer2.write(num + " ");
                }
                scanner.close();
                writer2.println();
            }
            System.out.println();
            writer2.close();

        }catch (IOException e){
            System.out.println("Error" + e);}}

    public static void main (String [] args) throws IOException {
        createNumbersFile();
        createOddNumbersFile();

    }
}
