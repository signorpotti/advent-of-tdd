package com.aoc;

import com.aoc.almanac.ReverseAlmanac;


public class Main {
    public static void main(String[] args) {
        ReverseAlmanac almanac = new ReverseAlmanac("D5/src/main/resources/aoc5input.txt");
        System.out.println("Min location: "+ almanac.getMinLocation());
    }
}