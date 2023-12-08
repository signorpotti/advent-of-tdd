package com.aoc.camelcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CamelCardReaderTest {

    @Test
    void calculate_winnings() {
        CamelCardReader ccr = new CamelCardReader(this.getClass().getClassLoader().getResource("winning6440.txt").getFile());
        //assertEquals(6440, ccr.getWinnings());
        assertEquals(5905, ccr.getWinnings());
    }
}