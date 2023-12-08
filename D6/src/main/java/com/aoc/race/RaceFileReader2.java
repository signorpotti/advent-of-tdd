package com.aoc.race;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaceFileReader2 {
    Race race;

    public RaceFileReader2(String path) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
            String line1=br.readLine();
            String time = line1.substring(line1.indexOf(":")+1).replace(" ", "");
            String line2=br.readLine();
            String distance = line2.substring(line2.indexOf(":")+1).replace(" ", "");

            race = new Race(Double.parseDouble(time), Double.parseDouble(distance));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Race getRace() {
        return race;
    }
}
