package com.aoc.race;


public class Race {
    double time, distance;

    public Race(double time, double distance) {
        this.time = time;
        this.distance = distance;
    }

    public int getNumberOfStrategies() {
        double charge1 = (time / 2) + Math.sqrt(Math.pow(time, 2) - 4 * distance) / 2;
        double charge2 = (time / 2) - Math.sqrt(Math.pow(time, 2) - 4 * distance) / 2;

        double smaller=Math.ceil(Math.min(charge1,charge2));
        double larger=Math.floor(Math.max(charge1,charge2));
        if(smaller==Math.min(charge1,charge2)){
            smaller++;
        }
        if(larger==Math.max(charge1,charge2)){
            larger--;
        }

        return (int)(larger-smaller+1);
    }

//    charge+move=time;
//    charge*move=distance;
//    charge*(time-charge)=distance;
//    0=charge^2-charge*time+distane;


    public double getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }
}
