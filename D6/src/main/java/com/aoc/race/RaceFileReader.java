package com.aoc.race;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceFileReader {
    List<Race> races=new ArrayList<>();

    public RaceFileReader(String path) {
         try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
             String line1=br.readLine();
             List<String> times = Arrays.stream(line1.substring(line1.indexOf(":")+1).split(" ")).filter(s->s.length()>0).toList();
             String line2=br.readLine();
             List<String> distances = Arrays.stream(line2.substring(line2.indexOf(":")+1).split(" ")).filter(s->s.length()>0).toList();
             for(int i=0; i<times.size();++i){
                 races.add(new Race(Double.parseDouble(times.get(i)), Double.parseDouble(distances.get(i))));
             }
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }

    public List<Race> getRaces() {
        return races;
    }
}
