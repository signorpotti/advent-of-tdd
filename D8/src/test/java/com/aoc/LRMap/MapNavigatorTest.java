package com.aoc.LRMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapNavigatorTest {

    @Test
    void how_many_steps_from_AAA_To_ZZZ() {
        MapNavigator navigator = new MapNavigator(this.getClass().getClassLoader().getResource("test6steps.txt").getFile());
        assertEquals(6,navigator.howManyStepsFromAAAToZZZ());

    }

    @Test
    void how_many_steps_from_AAA_To_ZZZ_with_multiple_starts() {
        MapNavigator navigator = new MapNavigator(this.getClass().getClassLoader().getResource("test6stepsPart2.txt").getFile());
        assertEquals(6,navigator.howManyStepsFromAAAToZZZ());

    }

}