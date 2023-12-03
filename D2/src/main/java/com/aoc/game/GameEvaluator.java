package com.aoc.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameEvaluator {

    private static int GREEN=13;
    private static int BLUE=14;
    private static int RED=12;


    public static int evaluate(String s) {
        List<String> lines = readFile(s);
        List<Game> possibleGames = lines.stream().map(Game::new).filter(GameEvaluator::isPossibleGame).toList();
        return possibleGames.stream().map(Game::getId).reduce(0,Integer::sum);
    }

    public static int calculatePower(String s) {
        List<String> lines = readFile(s);
        List<Integer> powerList = lines.stream().map(Game::new).map(Game::getPower).toList();
        return powerList.stream().reduce(0,Integer::sum);
    }

    private static boolean isPossibleGame(Game game){
        return game.getMaxBlue()<=BLUE && game.getMaxRed()<=RED && game.getMaxGreen()<=GREEN;
    }

    private static List<String> readFile(String path) {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


}
