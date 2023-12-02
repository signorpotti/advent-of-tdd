package calibration;

import com.aoc.calibration.CalibrationFileReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class CalibrationFileReaderTest {

    @Test
    void empty_file_read() {
        assertEquals(0, CalibrationFileReader.readFile(this.getClass().getClassLoader().getResource("empty.txt").getFile()).size());
    }

    @Test
    void multiple_line_file_read() {
        assertEquals(Arrays.asList(11,14,25), CalibrationFileReader.readFile(this.getClass().getClassLoader().getResource("11-14-25.txt").getFile()));
    }




}