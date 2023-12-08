package com.aoc.camelcards;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CamelCardReader {
    List<Hand> hands = new ArrayList<>();

    public CamelCardReader(String path) {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
            String line;
            while((line=br.readLine()) !=null){
                hands.add(new Hand(line));
            }
            Collections.sort(hands);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hand> getHands() {
        return hands;
    }
    public Integer getWinnings(){
        Integer result=0;
        for(int i=0;i<hands.size();++i){
            result+=hands.get(i).getBid()*(i+1);
        }
        return result;
    }
}
