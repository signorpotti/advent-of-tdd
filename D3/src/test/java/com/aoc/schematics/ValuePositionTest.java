package com.aoc.schematics;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValuePositionTest {
    @Test
    void test_area_matching(){
        ValuePosition plus=new ValuePosition(2,3,"+");
        NumberValuePosition ten=new NumberValuePosition(3,3,"10");
        assertTrue(plus.isInAreaOf(ten));
    }
}
