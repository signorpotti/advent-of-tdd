package com.aoc.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int id;
    private List<Hand> hands;

    public Game(String line) {
        hands=new ArrayList<>();
        int endOfId = line.indexOf(":");
        this.id=Integer.parseInt(line.substring(5,endOfId));

        String[] allHands=line.substring(endOfId+2).split("; ");
        for (String handStr: allHands) {
            hands.add(new Hand(handStr));
        }

    }

    public int getId() {
        return id;
    }

    public int getMaxBlue() {
        return hands.stream().map(Hand::getBlue).max(Integer::compareTo).orElse(0);

    }

    public int getMaxRed() {
        return hands.stream().map(Hand::getRed).max(Integer::compareTo).orElse(0);
    }

    public int getMaxGreen() {
        return hands.stream().map(Hand::getGreen).max(Integer::compareTo).orElse(0);
    }

    public int getPower(){
        return getMaxGreen()*getMaxRed()*getMaxBlue();
    }

    public static class Hand{
        int red,green,blue;

        public Hand(String hand) {
            String[] colors = hand.split(", ");
            for (String c : colors) {
                if(c.contains("red")){
                    red=Integer.parseInt(c.substring(0,c.length()-4));
                } else if (c.contains("green")) {
                    green=Integer.parseInt(c.substring(0,c.length()-6));
                } else if (c.contains("blue")) {
                    blue=Integer.parseInt(c.substring(0,c.length()-5));
                }
            }
        }

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public int getBlue() {
            return blue;
        }
    }

}
