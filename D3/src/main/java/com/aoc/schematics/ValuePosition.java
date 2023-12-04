package com.aoc.schematics;

import java.util.Objects;

public class ValuePosition {
    int row;
    int column;
    String value;

    public ValuePosition(int row, int column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    boolean isInAreaOf(NumberValuePosition n ){
        return row>=n.areaTop && row <=n.areaBottom && column>=n.areaLeft && column<=n.areaRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValuePosition that)) return false;
        return row == that.row && column == that.column && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, value);
    }
}
