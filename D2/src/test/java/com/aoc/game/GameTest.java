package com.aoc.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GameTest {

    @Test
    void game_id(){
        Game game = new Game("Game 15: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        assertEquals(15, game.getId());
    }

    @Test
    void max_cadance_per_color(){
        Game game = new Game("Game 15: 3 blue, 4 red; 1 red, 2 green, 6 blue; 130 green");
        assertEquals(6, game.getMaxBlue());
        assertEquals(4, game.getMaxRed());
        assertEquals(130, game.getMaxGreen());
    }

    @Test
    void only_one_color(){
        Game game = new Game("Game 15: 3 blue; 6 blue; 130 blue");
        assertEquals(130, game.getMaxBlue());
        assertEquals(0, game.getMaxRed());
        assertEquals(0, game.getMaxGreen());
    }

    @Test
    void calculate_power(){
        Game game = new Game("Game 15: 3 blue, 4 red; 1 red, 2 green, 6 blue; 130 green");
        assertEquals(6*130*4, game.getPower());
    }

}
