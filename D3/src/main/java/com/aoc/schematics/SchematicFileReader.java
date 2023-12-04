package com.aoc.schematics;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SchematicFileReader {

    List<List<ValuePosition>> schematics=new ArrayList<>();

    public SchematicFileReader(String path) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            int rowIndex=0;
            while ((line = br.readLine()) != null) {
                schematics.add(ValuePositionFactory.read(rowIndex++, line));

            }
            calculateGears();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<List<ValuePosition>> getSchematics() {
        return schematics;
    }

    public List<NumberValuePosition> findPartNumbers(){
        List<NumberValuePosition> result=new ArrayList<>();
        for(int i=0;i<schematics.size();++i){
            List<NumberValuePosition> numbers = schematics.get(i).stream().filter(v-> v instanceof NumberValuePosition).map(v -> (NumberValuePosition)v).toList();
            List<ValuePosition> characters = new ArrayList<>();
            characters.addAll(schematics.get(i).stream().filter(v-> !(v instanceof NumberValuePosition)).toList());
            if(i>0){
                characters.addAll(schematics.get(i-1).stream().filter(v-> !(v instanceof NumberValuePosition)).toList());
            }
            if(i<schematics.size()-1){
                characters.addAll(schematics.get(i+1).stream().filter(v-> !(v instanceof NumberValuePosition)).toList());
            }
            for (NumberValuePosition number : numbers) {
                for (ValuePosition character : characters) {
                    if(character.isInAreaOf(number)){
                        result.add(number);
                    }
                }
            }
        }
        return result;
    }

    public List<GearValuePosition> getGears(){
        return schematics.stream().flatMap(Collection::stream).filter(v->v instanceof GearValuePosition).map(g -> (GearValuePosition)g).toList();
    }

    private void calculateGears(){
        for(int i=0;i<schematics.size();++i){
            List<NumberValuePosition> numbers = schematics.get(i).stream().filter(v-> v instanceof NumberValuePosition).map(v -> (NumberValuePosition)v).toList();
            List<GearValuePosition> gears = new ArrayList<>();
            gears.addAll(schematics.get(i).stream().filter(v-> v instanceof GearValuePosition).map(v->(GearValuePosition)v).toList());
            if(i>0){
                gears.addAll(schematics.get(i-1).stream().filter(v-> v instanceof GearValuePosition).map(v->(GearValuePosition)v).toList());
            }
            if(i<schematics.size()-1){
                gears.addAll(schematics.get(i+1).stream().filter(v-> v instanceof GearValuePosition).map(v->(GearValuePosition)v).toList());
            }
            for (NumberValuePosition number : numbers) {
                for (GearValuePosition gear : gears) {
                    if(gear.isInAreaOf(number)){
                        gear.addGear(number.numberValue);
                    }
                }
            }
        }
    }
}
