package com.aoc.almanac;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class ReverseAlmanac {
    List<BigInteger> seeds= new ArrayList<>();

    LinkedList<TreeMap<BigInteger, MapItem>> mappings=new LinkedList<>();

    BigInteger minLocation=null;

    public ReverseAlmanac(String path) {
        try (BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(path))) ){
            String line=br.readLine();
            initSeeds(line);
            while((line=br.readLine())!=null){
                if(line.contains("map")){
                    mappings.add(new TreeMap<>());
                }else if(line.length()>0){
                    MapItem mi = new MapItem(line);
                    mappings.getLast().put(mi.destination, mi);
                }
            }
            calculateMinLocation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void calculateMinLocation() {
        SortedSet<BigInteger> sortedLocations = new TreeSet<>(mappings.getLast().keySet());
        for (BigInteger locationKey: sortedLocations){
            MapItem mi = mappings.getLast().get(locationKey);
            BigInteger start=mi.destination;
            BigInteger end=mi.destination.add(mi.length);
            for(BigInteger i=start; i.compareTo(end)<0;i=i.add(BigInteger.ONE)){
                Iterator<TreeMap<BigInteger, MapItem>> it = mappings.descendingIterator();
                BigInteger seed=i;
                while(it.hasNext()){
                    TreeMap<BigInteger,MapItem> map = it.next();
                    BigInteger key = map.floorKey(seed);
                    seed=map.get(key).reverseMap(seed);
                }
                for(int s=0;s<seeds.size();++s){
                    BigInteger seedStart = seeds.get(s);
                    BigInteger seedEnd= seedStart.add(seeds.get(++s));
                    if(seed.compareTo(seedStart)>=0 && seed.compareTo(seedEnd)<0){
                        minLocation=i;
                        return;
                    }
                }
            }
        }
    }

    private void initSeeds(String line) {
        seeds= Arrays.stream(line.substring(line.indexOf(":")+1).split(" ")).filter(s->s.length()>0).map(BigInteger::new).toList();
    }

    public BigInteger getMinLocation() {
        return minLocation;
    }

}
