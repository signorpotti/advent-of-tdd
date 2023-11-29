package org.advent.day1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestElfShould {
    @Test
    void have_zero_total_calories_when_created() {
        Elf elf = new Elf();
        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void have_1000_total_calories_after_adding_1000() {
       Elf elf = new Elf();
       elf.addCalories(1000);
       assertThat(elf.getTotalCalories(), equalTo(1000));
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        Elf elf1 = new Elf();
        elf1.addCalories(1);
        Elf elf2 = new Elf();
        elf2.addCalories(2);
        assertTrue(elf2.compareTo(elf1) > 0);
    }

    @Test
    void compare_zero_for_equal_elf() {
        Elf elf = new Elf();
        elf.addCalories(1);
        assertEquals(0, elf.compareTo(elf));
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        Elf elf1 = new Elf();
        elf1.addCalories(1);
        Elf elf2 = new Elf();
        elf2.addCalories(2);
        assertTrue(elf1.compareTo(elf2) < 0);
    }
}
