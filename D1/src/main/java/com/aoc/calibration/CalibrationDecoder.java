package com.aoc.calibration;

import java.util.Map;

public class CalibrationDecoder {

    public static final int ZERO = 48;
    public static final int NINE = 57;
    public static final int ASCII_OFFSET = 48;
    private static Map<String,Integer> NUMBERS = Map.of("one",1,"two",2, "three",3, "four", 4,"five", 5,"six",6, "seven",7, "eight",8, "nine",9 );

    public static Integer decode(String line) {
        Integer result = null;
        NumberPosition npFirstInt=getFirstInt(line);
        NumberPosition npLastInt=null;
        NumberPosition npFirstStr=null;
        NumberPosition npLastStr=null;
        if(npFirstInt!=null){
            npLastInt=getLastInt(line);
            npFirstStr=getFirstString(line.substring(0,npFirstInt.position));
            npLastStr=getLastString(line.substring(npLastInt.position),npLastInt.position );
        }else{
            npFirstStr=getFirstString(line);
            npLastStr=getLastString(line, 0);
        }
        NumberPosition np1=NumberPosition.FIRST(npFirstInt,npFirstStr);
        NumberPosition np2=NumberPosition.LAST(npLastInt,npLastStr);
        if (np1 != null) {
            result=np1.number*10;
            result+=np2.number;
        }
        return result;
    }

    private static NumberPosition getFirstInt(String line){
        NumberPosition result = null;
        char[] charAr = line.toCharArray();
        for(int i=0; i<charAr.length;++i){
            if(charAr[i]>= ZERO && charAr[i]<= NINE){
                result=new NumberPosition(((int)charAr[i])- ASCII_OFFSET,i);
                break;
            }
        }
        return result;
    }

    private static NumberPosition getLastInt(String line){
        NumberPosition result = null;
        char[] charAr = line.toCharArray();
        for(int i=charAr.length-1; i>-1;--i){
            if(charAr[i]>=ZERO && charAr[i]<=NINE){
                result=new NumberPosition(((int)charAr[i])-ASCII_OFFSET,i);
                break;
            }
        }
        return result;
    }

    private static NumberPosition getFirstString(String line){
        NumberPosition np=null;
        int index=line.length();
        for(String number: NUMBERS.keySet()){
            int i = line.indexOf(number);
            if( i> -1 && i<index ){
                index=i;
                np=new NumberPosition(NUMBERS.get(number),i);
            }
        }
        return np;
    }

    private static NumberPosition getLastString(String line, int offset){
        NumberPosition np = getLastString(line);
        if(np!=null) {np.position+=offset;}
        return np;
    }

    private static NumberPosition getLastString(String line){
        NumberPosition np=null;
        int index=-1;
        for(String number: NUMBERS.keySet()){
            int i = line.lastIndexOf(number);
            if( i> -1 && i>index ){
                index=i;
                np=new NumberPosition(NUMBERS.get(number),i);
            }
        }
        return np;
    }

    public static class NumberPosition {
        int number;
        int position;

        public NumberPosition(int number, int position) {
            this.number = number;
            this.position = position;
        }

        public static NumberPosition FIRST(NumberPosition np1, NumberPosition np2) {
            if (np1 != null) {
                if (np2 != null) {
                    return np1.position < np2.position ? np1 : np2;
                } else {
                    return np1;
                }
            } else {
                return np2;
            }
        }

        public static NumberPosition LAST(NumberPosition np1, NumberPosition np2) {
            if (np1 != null) {
                if (np2 != null) {
                    return np1.position > np2.position ? np1 : np2;
                } else {
                    return np1;
                }
            } else {
                    return np2;
            }
        }

    }
}
