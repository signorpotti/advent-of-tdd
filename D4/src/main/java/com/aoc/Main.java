package com.aoc;

import com.aoc.scratchcard.ScratchCard;
import com.aoc.scratchcard.ScratchCardFileReader;

public class Main {
    public static void main(String[] args) {
        ScratchCardFileReader cardFileReader = new ScratchCardFileReader("D4/src/main/resources/aoc4input.txt");

        System.out.println(cardFileReader.getCards().stream().map(ScratchCard::getScore).reduce(0,Integer::sum));

        System.out.println(cardFileReader.getCards().stream().map(ScratchCard::getCount).reduce(0,Integer::sum));
    }
}