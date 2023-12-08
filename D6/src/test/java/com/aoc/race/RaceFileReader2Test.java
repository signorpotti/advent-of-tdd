package com.aoc.race;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceFileReader2Test {

    @Test
    void race_file_read() {
        RaceFileReader2 reader=new RaceFileReader2(this.getClass().getClassLoader().getResource("test-input.txt").getFile());
        assertEquals(71530, reader.getRace().getTime());
        assertEquals(940200, reader.getRace().getDistance());
    }
}