package com.aoc.LRMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRPointTest {

    @Test
    void test_turn() {
        LRPoint point=new LRPoint("BBB = (AAA, ZZZ)");
        assertEquals("AAA", point.turn('L'));
        assertEquals("ZZZ", point.turn('R'));
    }
}