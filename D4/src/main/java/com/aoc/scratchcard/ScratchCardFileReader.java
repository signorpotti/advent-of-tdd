package com.aoc.scratchcard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScratchCardFileReader {
    List<ScratchCard> cards=new ArrayList<>();

    public ScratchCardFileReader(String path) {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
            String line;
            while((line = br.readLine()) != null){
                cards.add(new ScratchCard(line));
            }
            evaluateCards();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ScratchCard> getCards() {
        return cards;
    }

    private void evaluateCards(){
        for(int i=0;i< cards.size();++i){
            for(int j=0;j< cards.get(i).getCount();++j){
                for(int k=0; k<cards.get(i).getMatching() && i+k+1< cards.size() ;++k){
                    cards.get(i+k+1).addAnother();
                }
            }
        }
    }

}
