package com.aoc.almanac;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlmanacTest {
    @Test
    void mapping_of_seed() {
        ReverseAlmanac almanac = new ReverseAlmanac(this.getClass().getClassLoader().getResource("four-seeds-almanac.txt").getFile());
        assertEquals(BigInteger.valueOf(56), almanac.getMinLocation());
    }
}