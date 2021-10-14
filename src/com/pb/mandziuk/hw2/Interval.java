package com.pb.mandziuk.hw2;

import java.util.Scanner;

public class Interval {
public static void main(String[] args) {
    System.out.println("Guess the interval");
    Scanner scan = new Scanner(System.in);
    double x;
    x = scan.nextDouble();
    if (x>=0 && x<=14) {
        System.out.println("Yor interval is [0-14]");}
        else if (x>=15 && x<=35) {
        System.out.println("Yor interval is [15-35]");}
    else if (x>=36 && x<=50) {
        System.out.println("Yor interval is [36-50]");}
    else if (x>=51 && x<=100) {
        System.out.println("Yor interval is [51-100]");}
    else if (x>=101) {
        System.out.println("It`s not your day. Guess more");}
    else if (x<=-1) {
        System.out.println("It`s not your day. Guess more");}

}
}
