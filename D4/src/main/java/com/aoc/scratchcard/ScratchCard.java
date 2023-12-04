package com.aoc.scratchcard;

import java.util.Arrays;
import java.util.Collection;

public class ScratchCard {
    private int matching=0;
    private int count=1;

    public ScratchCard(String line) {
        int cardStart=line.indexOf(":");
        String card=line.substring(cardStart+1);
        String[] cardParts=card.split("\\|");
        Collection<Integer> winningNumbers = Arrays.stream(cardParts[0].split(" ")).filter(s->s.length()>0).map(Integer::parseInt).toList();
        Collection<Integer> playingNumbers = Arrays.stream(cardParts[1].split(" ")).filter(s->s.length()>0).map(Integer::parseInt).toList();
        matching=(int)playingNumbers.stream().filter(winningNumbers::contains).count();
    }

    public int getScore(){
        return (int)Math.pow(2,matching-1);
    }

    public int getMatching(){
        return matching;
    }

    public int getCount() {
        return count;
    }

    public void addAnother(){
        ++count;
    }
}
