package com.aoc;

import com.aoc.calibration.CalibrationCalculator;
import com.aoc.calibration.CalibrationFileReader;

public class Main {
    public static void main(String[] args) {
        System.out.println(CalibrationCalculator.calculate(CalibrationFileReader.readFile("D1/src/main/resources/aoc1input.txt")));
    }
}