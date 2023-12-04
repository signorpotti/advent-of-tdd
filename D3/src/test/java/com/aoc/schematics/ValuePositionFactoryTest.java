package com.aoc.schematics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ValuePositionFactoryTest {
    @Test
    void character_and_position_read() {
        List<ValuePosition> vpList = ValuePositionFactory.read(0, ".....+.58.");
        assertEquals(2, vpList.size());
        assertEquals("+", vpList.get(0).value);
        assertEquals(0, vpList.get(0).row);
        assertEquals(5, vpList.get(0).column);

        assertEquals("58", vpList.get(1).value);
        assertEquals(0, vpList.get(1).row);
        assertEquals(7, vpList.get(1).column);
    }

    @Test
    void character_at_the_begining_and_end() {
        List<ValuePosition> vpList = ValuePositionFactory.read(0, "$.....+");
        assertEquals(2, vpList.size());
        assertEquals("+", vpList.get(1).value);
        assertEquals(0, vpList.get(1).row);
        assertEquals(6, vpList.get(1).column);


        assertEquals("$", vpList.get(0).value);
        assertEquals(0, vpList.get(0).row);
        assertEquals(0, vpList.get(0).column);
    }

    @Test
    void only_dots_in_the_line() {
        List<ValuePosition> vpList = ValuePositionFactory.read(0, "....");
        assertEquals(0, vpList.size());
    }

    @Test
    void no_dots_in_the_line() {
        List<ValuePosition> vpList = ValuePositionFactory.read(15, "12+12&23");
        assertEquals(5, vpList.size());

        assertEquals("12", vpList.get(0).value);
        assertEquals(15, vpList.get(0).row);
        assertEquals(0, vpList.get(0).column);

        assertEquals("+", vpList.get(1).value);
        assertEquals(15, vpList.get(1).row);
        assertEquals(2, vpList.get(1).column);

        assertEquals("12", vpList.get(2).value);
        assertEquals(15, vpList.get(2).row);
        assertEquals(3, vpList.get(2).column);

        assertEquals("&", vpList.get(3).value);
        assertEquals(15, vpList.get(3).row);
        assertEquals(5, vpList.get(3).column);

        assertEquals("23", vpList.get(4).value);
        assertEquals(15, vpList.get(4).row);
        assertEquals(6, vpList.get(4).column);
    }
}