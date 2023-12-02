package com.aoc.calibration;

import java.util.List;

public class CalibrationCalculator {
    public static Integer calculate(List<Integer> input){
        return input.stream().reduce(0,Integer::sum);
    }
}
