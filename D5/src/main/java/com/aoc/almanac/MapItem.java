package com.aoc.almanac;

import java.math.BigInteger;

public class MapItem {
    BigInteger destination, source,length;

    public MapItem(String line) {
        String[] numbers = line.split(" ");
        destination = new BigInteger(numbers[0]);
        source = new BigInteger(numbers[1]);
        length = new BigInteger(numbers[2]);
    }

    public BigInteger map(BigInteger i){
        if(i.compareTo(source)>=0 && i.compareTo(source.add(length))<0){
            return destination.add(i).subtract(source);
        }
        return i;
    }

    public BigInteger reverseMap(BigInteger i){
        if(i.compareTo(destination)>=0 && i.compareTo(destination.add(length))<0){
            return source.add(i).subtract(destination);
        }
        return i;
    }
}
