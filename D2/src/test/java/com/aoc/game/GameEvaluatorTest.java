package com.aoc.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameEvaluatorTest {

    @Test
    void one_line_file_possible(){
        assertEquals(1, GameEvaluator.evaluate(this.getClass().getClassLoader().getResource("1-line.txt").getFile()));
    }

    @Test
    void three_line_file_sum_10(){
        assertEquals(10, GameEvaluator.evaluate(this.getClass().getClassLoader().getResource("3-line-result-10.txt").getFile()));
    }

    @Test
    void one_line_file_power() {
        assertEquals(6*4*2, GameEvaluator.calculatePower(this.getClass().getClassLoader().getResource("1-line.txt").getFile()));
    }

    @Test
    void three_line_file_power(){
        assertEquals((6*4*2)+(14*12*13)+(20*4*2), GameEvaluator.calculatePower(this.getClass().getClassLoader().getResource("3-line-result-10.txt").getFile()));
    }

}
