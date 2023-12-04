package com.aoc.schematics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GearValuePosition extends ValuePosition{

    List<Integer> gears=new ArrayList<>();
    public GearValuePosition(int row, int column, String value) {
        super(row, column, value);
    }

    public GearValuePosition(int row, int column, String value, List<Integer> gears) {
        super(row, column, value);
        this.gears = gears;
    }

    public void addGear(Integer g){
        gears.add(g);
    }

    public Integer getGear(){
        if(gears.size()==2){
            return gears.get(0)*gears.get(1);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GearValuePosition that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(gears, that.gears);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gears);
    }
}
