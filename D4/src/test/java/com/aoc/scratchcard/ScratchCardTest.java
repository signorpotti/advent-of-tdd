package com.aoc.scratchcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ScratchCardTest {
    @Test
    void scratchcard_0_point(){
        ScratchCard card = new ScratchCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");
        assertEquals(0,card.getScore());
    }

    @Test
    void scratchcard_1_point(){
        ScratchCard card = new ScratchCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 31");
        assertEquals(1,card.getScore());
    }

    @Test
    void scratchcard_8_point(){
        ScratchCard card = new ScratchCard("Card 6: 31 18 13 56 72 | 72 77 18 23 13 67 36 31");
        assertEquals(8,card.getScore());
    }

    @Test
    void scratchcard_1_matching(){
        ScratchCard card = new ScratchCard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 31");
        assertEquals(1,card.getMatching());
    }

    @Test
    void scratchcard_4_matching(){
        ScratchCard card = new ScratchCard("Card 6: 31 18 13 56 72 | 72 77 18 23 13 67 36 31");
        assertEquals(4,card.getMatching());
    }
}
