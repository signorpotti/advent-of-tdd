package com.aoc.schematics;

import java.util.ArrayList;
import java.util.List;

public class ValuePositionFactory {

    public static List<ValuePosition> read(int rowNumber, String line) {
        List<ValuePosition> result = new ArrayList<>();
        String number=null;
        for (int i=0;i<line.length();++i){
            char c = line.charAt(i);
            if (c>='0' && c<= '9') {
                if(number!=null){
                    number += c;
                }else {
                    number = String.valueOf(c);
                }
            }else {
                if(number!=null){
                    result.add(new NumberValuePosition(rowNumber, i-number.length(),number));
                    number=null;
                }
                if(c=='*'){
                    result.add(new GearValuePosition(rowNumber,i,String.valueOf(c)));
                }else if(c!='.') {
                    result.add(new ValuePosition(rowNumber,i,String.valueOf(c)));
                }
            }
        }
        if(number!=null) {
            result.add(new NumberValuePosition(rowNumber, line.length() - number.length(), number));
        }
        return result;
    }
}
