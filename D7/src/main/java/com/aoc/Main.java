package com.aoc;

import com.aoc.camelcards.CamelCardReader;

public class Main {
    public static void main(String[] args) {
        CamelCardReader ccr = new CamelCardReader("D7/src/main/resources/aoc7input.txt");
        System.out.println(ccr.getWinnings());
    }
}