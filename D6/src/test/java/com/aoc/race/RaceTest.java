package com.aoc.race;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    void race_strategies_calculated(){
        Race r=new Race(7,9);
        assertEquals(4, r.getNumberOfStrategies());
        r=new Race(15,40);
        assertEquals(8, r.getNumberOfStrategies());
        r=new Race(30,200);
        assertEquals(9, r.getNumberOfStrategies());
    }
}