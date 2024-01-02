package com.aoc.LRMap;

public class LRPoint {
    String value, left, right;

    public LRPoint(String line) {
        value=line.substring(0,3);
        left=line.substring(7,10);
        right=line.substring(12,15);
    }

    public String turn(char lr){
        if(lr=='L'){
            return left;
        }else{
            return right;
        }
    }

    public String getValue() {
        return value;
    }
}

