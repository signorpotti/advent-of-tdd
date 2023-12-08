package com.aoc.camelcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hand  implements Comparable<Hand>{

    Type type;
    Integer value;
    Integer bid;



    public Hand(String line) {
        String[] parts=line.split(" ");
        bid=Integer.parseInt(parts[1]);
        String cards=parts[0];

        value=Integer.parseInt(cards.replace("J", "1").replace("Q", "C").replace("K", "D").replace("A", "E").replace("T", "A"),16);

        HashMap<Character, Integer> cardCounts =  new HashMap<>();
        for (char c:cards.toCharArray()){
            cardCounts.computeIfPresent(c, (k,v)->v+1);
            cardCounts.putIfAbsent(c,1);
        }
        Integer jokers = 0;
        if(cardCounts.containsKey('J')) {
            jokers = cardCounts.remove('J');
        }

        ArrayList<Integer> values = new ArrayList<>(cardCounts.values());
        Collections.sort(values);
        Collections.reverse(values);

        if(jokers == 5){
            type=Type.FIVE;
        } else if(values.get(0)+jokers==5){
            type=Type.FIVE;
        } else if (values.get(0)+jokers==4) {
            type=Type.FOUR;
        } else if(values.get(0)+jokers==3 && values.get(1)==2){
            type=Type.FULL_HOUSE;
        } else if (values.get(0)+jokers==3 && values.get(1)==1){
            type=Type.THREE;
        } else if (values.get(0)+jokers==2 && values.get(1)==2){
            type=Type.TWO_PAIR;
        } else if (values.get(0)+jokers==2 && values.get(1)==1) {
            type = Type.ONE_PAIR;
        } else {
            type=Type.HIGH_CARD;
        }
    }

    @Override
    public int compareTo(Hand o) {
        if(this.type.equals(o.type)){
            return this.value-o.value;
        }else {
            return this.type.getValue()-o.type.getValue();
        }
    }

    public Integer getBid() {
        return bid;
    }

    enum Type {
        HIGH_CARD(0),ONE_PAIR(1),TWO_PAIR(2),THREE(3),FULL_HOUSE(4),FOUR(5),FIVE(6);

        private final int value;

        Type(int i) {
            this.value=i;
        }

        public int getValue() {
            return value;
        }
    }


}
