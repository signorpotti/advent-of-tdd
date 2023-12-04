package com.aoc.schematics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchematicFileReaderTest {
    @Test
    void four_lines_read() {
        SchematicFileReader schematicFileReader = new SchematicFileReader(this.getClass().getClassLoader().getResource("4-lines.txt").getFile());
        assertEquals(4, schematicFileReader.getSchematics().size());
    }

    @Test
    void four_lines_read_to_characters_and_numbers() {
        SchematicFileReader schematics = new SchematicFileReader(this.getClass().getClassLoader().getResource("4-lines.txt").getFile());
        List<ValuePosition> line1 = Arrays.asList(new NumberValuePosition(0,0,"467"), new NumberValuePosition(0,5,"114"));
        List<ValuePosition> line2 = List.of(new GearValuePosition(1, 3, "*", Arrays.asList(467, 35)));
        List<ValuePosition> line3 = Arrays.asList(new NumberValuePosition(2,2,"35"), new NumberValuePosition(2,6,"633"));
        List<ValuePosition> line4 = List.of(new ValuePosition(3, 6, "#"));

        List<List<ValuePosition>> expected = Arrays.asList(line1, line2, line3, line4);

        assertEquals(expected, schematics.getSchematics());

    }

    @Test
    void four_lines_read_to_part_numbers() {
        SchematicFileReader schematics = new SchematicFileReader(this.getClass().getClassLoader().getResource("4-lines.txt").getFile());

        List<NumberValuePosition> expected = Arrays.asList(new NumberValuePosition(0,0,"467"), new NumberValuePosition(2,2,"35"), new NumberValuePosition(2,6,"633"));

        assertEquals(expected, schematics.findPartNumbers());

    }

    @Test
    void calculate_gears(){
        SchematicFileReader schematics = new SchematicFileReader(this.getClass().getClassLoader().getResource("4-lines.txt").getFile());
        GearValuePosition g = new GearValuePosition(1,3,"*");
        g.addGear(467);
        g.addGear(35);
        List<GearValuePosition> expected = Arrays.asList(g);
        List<GearValuePosition> actual = schematics.getGears();
        assertEquals(expected, actual );
        assertEquals(g.getGear(), actual.get(0).getGear());
    }

}