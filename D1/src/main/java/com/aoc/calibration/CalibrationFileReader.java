package com.aoc.calibration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CalibrationFileReader {
    public static List<Integer> readFile(String path) {
        ArrayList<Integer> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                Integer i = CalibrationDecoder.decode(line);
                if (i != null) {
                    result.add(i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
