package com.aoc;

import com.aoc.schematics.GearValuePosition;
import com.aoc.schematics.NumberValuePosition;
import com.aoc.schematics.SchematicFileReader;

public class Main {
    public static void main(String[] args) {

        SchematicFileReader schematicFileReader = new SchematicFileReader("D3/src/main/resources/aoc3input.txt");

        System.out.println(schematicFileReader.findPartNumbers().stream().map(NumberValuePosition::getNumberValue).reduce(0, Integer::sum));

        System.out.println(schematicFileReader.getGears().stream().map(GearValuePosition::getGear).reduce(0, Integer::sum));

    }
}