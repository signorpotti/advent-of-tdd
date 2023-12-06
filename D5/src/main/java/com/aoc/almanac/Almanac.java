package com.aoc.almanac;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Almanac {
    List<BigInteger> seeds= new ArrayList<>();

    LinkedList<TreeMap<BigInteger, MapItem>> mappings=new LinkedList<>();

    BigInteger minLocation=null;

    public Almanac(String path) {
        try (BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(path))) ){
          String line=br.readLine();
          initSeeds(line);
          while((line=br.readLine())!=null){
              if(line.contains("map")){
                  mappings.add(new TreeMap<>());
              }else if(line.length()>0){
                  MapItem mi = new MapItem(line);
                  mappings.getLast().put(mi.source, mi);
              }
          }
          calculateSeedsLocation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void calculateSeedsLocation() {
        for(int i=0;i<seeds.size();++i){
            BigInteger start = seeds.get(i);
            BigInteger end= start.add(seeds.get(++i));
            for(BigInteger k=start;k.compareTo(end)<0;k=k.add(BigInteger.ONE)){
                BigInteger location = mapSeed(k);
                if(minLocation==null || location.compareTo(minLocation)<0){
                    minLocation=location;
                }
            }
        }
    }

    private void initSeeds(String line) {
        seeds=Arrays.stream(line.substring(line.indexOf(":")+1).split(" ")).filter(s->s.length()>0).map(BigInteger::new).toList();
    }

    public List<BigInteger> getSeeds() {
        return seeds;
    }

    public LinkedList<TreeMap<BigInteger, MapItem>> getMappings() {
        return mappings;
    }

    private BigInteger mapSeed(BigInteger seed){
        BigInteger result=seed;
        for (TreeMap<BigInteger, MapItem> mapping : mappings){
            BigInteger mapKey = mapping.floorKey(result);
            if(mapKey!=null){
                result=mapping.get(mapKey).map(result);
            }
        }
        return result;
    }

    public BigInteger getMinLocation() {
        return minLocation;
    }

}
