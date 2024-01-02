package com.aoc.LRMap;

public class Circle implements Comparable<Circle>{
    int offset, length;

    public Circle(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    @Override
    public int compareTo(Circle c) {
        return this.length-c.length;
    }
}
