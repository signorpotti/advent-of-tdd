package com.aoc.race;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceFileReaderTest {

    @Test
    void race_read_from_file() {
        RaceFileReader reader=new RaceFileReader(this.getClass().getClassLoader().getResource("test-input.txt").getFile());
        assertEquals(3, reader.getRaces().size());
        assertEquals(288, reader.getRaces().stream().map(Race::getNumberOfStrategies).reduce(1, (r,e)->r*e));

    }
}