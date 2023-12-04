package com.aoc.scratchcard;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ScratchCardFileReaderTest {

    @Test
    void cars_read_from_file() {
        ScratchCardFileReader cardFileReader = new ScratchCardFileReader(this.getClass().getClassLoader().getResource("card-input.txt").getFile());
        List<ScratchCard> cards = cardFileReader.getCards();
        assertEquals(8,cards.get(0).getScore());
        assertEquals(2,cards.get(1).getScore());
        assertEquals(2,cards.get(2).getScore());
        assertEquals(1,cards.get(3).getScore());
        assertEquals(0,cards.get(4).getScore());
        assertEquals(0,cards.get(5).getScore());
    }

    @Test
    void cards_read_and_evaluated() {
        ScratchCardFileReader cardFileReader = new ScratchCardFileReader(this.getClass().getClassLoader().getResource("card-input.txt").getFile());
        List<ScratchCard> cards = cardFileReader.getCards();
        assertEquals(8,cards.get(0).getScore());
        assertEquals(2,cards.get(1).getScore());
        assertEquals(2,cards.get(2).getScore());
        assertEquals(1,cards.get(3).getScore());
        assertEquals(0,cards.get(4).getScore());
        assertEquals(0,cards.get(5).getScore());

        assertEquals(1,cards.get(0).getCount());
        assertEquals(2,cards.get(1).getCount());
        assertEquals(4,cards.get(2).getCount());
        assertEquals(8,cards.get(3).getCount());
        assertEquals(14,cards.get(4).getCount());
        assertEquals(1,cards.get(5).getCount());
    }
}