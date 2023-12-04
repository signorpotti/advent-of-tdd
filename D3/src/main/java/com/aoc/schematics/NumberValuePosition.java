package com.aoc.schematics;

import java.util.Objects;

public class NumberValuePosition extends AreaValuePosition{

    public NumberValuePosition(int row, int column, String value) {
        super(row, column, value);
        numberValue=Integer.parseInt(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberValuePosition that)) return false;
        return areaTop == that.areaTop && areaLeft == that.areaLeft && areaBottom == that.areaBottom && areaRight == that.areaRight && numberValue == that.numberValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaTop, areaLeft, areaBottom, areaRight, numberValue);
    }

}
