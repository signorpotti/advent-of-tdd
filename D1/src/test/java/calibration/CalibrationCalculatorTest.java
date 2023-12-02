package calibration;

import com.aoc.calibration.CalibrationCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

class CalibrationCalculatorTest {
    @Test
    void empty_list_is_zero(){
        assertEquals(0, CalibrationCalculator.calculate(Collections.emptyList()));
    }

    @Test
    void elements_added(){
        assertEquals(50, CalibrationCalculator.calculate(Arrays.asList(11,14,25)));
    }
}