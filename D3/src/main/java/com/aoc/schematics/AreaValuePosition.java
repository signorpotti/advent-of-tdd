package com.aoc.schematics;

public class AreaValuePosition extends ValuePosition{

    int areaTop, areaLeft, areaBottom, areaRight;
    int numberValue;

    public AreaValuePosition(int row, int column, String value) {
        super(row, column, value);
        areaTop=row-1;
        areaBottom=row+1;
        areaLeft=column-1;
        areaRight=column+value.length();
    }

    public int getNumberValue() {
        return numberValue;
    }

}
