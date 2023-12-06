package com.aoc.almanac;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MapItemTest {

    @Test
    void map_item_read_test() {
        MapItem mi = new MapItem("50 98 2 ");
        assertEquals(BigInteger.valueOf(50),mi.destination);
        assertEquals(BigInteger.valueOf(98),mi.source);
        assertEquals(BigInteger.valueOf(2),mi.length);
    }

    @Test
    void map_item_mapping_test() {
        MapItem mi = new MapItem("50 98 2 ");
        assertEquals(BigInteger.valueOf(50),mi.map(BigInteger.valueOf(98)));
        assertEquals(BigInteger.valueOf(51),mi.map(BigInteger.valueOf(99)));
        assertEquals(BigInteger.valueOf(100),mi.map(BigInteger.valueOf(100)));
    }


}