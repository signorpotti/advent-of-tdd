package com.aoc.almanac;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlmanacTest {

    @Test
    void seeds_read_to_almanac() {
        Almanac almanac = new Almanac(this.getClass().getClassLoader().getResource("four-seeds-almanac.txt").getFile());
        List<BigInteger> seeds= Arrays.asList(BigInteger.valueOf(79), BigInteger.valueOf(14), BigInteger.valueOf(55), BigInteger.valueOf(13));
        //assertEquals(27, almanac.getSeeds().size());
        //almanac.getSeeds().stream().forEach(s -> assertTrue((s.compareTo(BigInteger.valueOf(79))>=0 && s.compareTo(BigInteger.valueOf(93))<0)||(s.compareTo(BigInteger.valueOf(55))>=0 && s.compareTo(BigInteger.valueOf(68))<0)));
        assertEquals(seeds, almanac.getSeeds());
    }

    @Test
    void mappings_read_to_almanac() {
        Almanac almanac = new Almanac(this.getClass().getClassLoader().getResource("four-seeds-almanac.txt").getFile());
        assertEquals(7,almanac.getMappings().size());
        assertEquals(2,almanac.getMappings().get(0).size());
        assertEquals(3,almanac.getMappings().get(1).size());
        assertEquals(4,almanac.getMappings().get(2).size());
        assertEquals(2,almanac.getMappings().get(3).size());
        assertEquals(3,almanac.getMappings().get(4).size());
        assertEquals(2,almanac.getMappings().get(5).size());
        assertEquals(2,almanac.getMappings().get(6).size());
    }

    @Test
    void mapping_of_seed() {
        Almanac almanac = new Almanac(this.getClass().getClassLoader().getResource("four-seeds-almanac.txt").getFile());
        assertEquals(BigInteger.valueOf(46), almanac.getMinLocation());
    }
}