package calibration;

import com.aoc.calibration.CalibrationDecoder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CalibrationDecoderTest {

    @Test
    void empty_line_null(){
        assertNull(CalibrationDecoder.decode(""));
    }

    @Test
    void one_digit_line_to_value(){
        assertEquals(11, CalibrationDecoder.decode("1"));
    }

    @Test
    void two_digit_line_to_value(){
        assertEquals(13, CalibrationDecoder.decode("13"));
    }

    @Test
    void two_digit_line_with_characters_to_value(){
        assertEquals(13, CalibrationDecoder.decode("sadf1sdhg3sdfh"));
    }

    @Test
    void four_digit_line_with_characters_to_value(){
        assertEquals(14, CalibrationDecoder.decode("sadf1s2d3hg4sdfh"));
    }

    @Test
    void number_word_to_value(){
        assertEquals(11, CalibrationDecoder.decode("one"));
    }

    @Test
    void multiple_number_words_with_extra_characters_to_value(){
        assertEquals(13, CalibrationDecoder.decode("safoneasdtwofthreeoasdfd"));
    }

    @Test
    void multiple_number_words_with_overlapping_characters_to_value(){
        assertEquals(83, CalibrationDecoder.decode("eighthree"));
    }

    @Test
    void multiple_number_words_and_digits_with_extra_characters_to_value(){
        assertEquals(83, CalibrationDecoder.decode("saf8oneasdtwof9threeoasdfd"));
    }

}