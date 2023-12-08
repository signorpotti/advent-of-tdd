package com.aoc.camelcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void compare_hands() {
        Hand onePair = new Hand("32T3K 0");
        Hand twoPairs = new Hand("22T33 0");
        Hand three = new Hand("32T33 0");
        Hand four = new Hand("33T33 0");
        Hand fullHouse = new Hand("3TT33 0");
        Hand five = new Hand("33333 0");
        Hand biggerFullHouse = new Hand("3AA33 0");
        Hand highCard = new Hand("3AKQT 0");
        assertTrue(highCard.compareTo(onePair)<0);
        assertTrue(onePair.compareTo(twoPairs)<0);
        assertTrue(twoPairs.compareTo(three)<0);
        assertTrue(three.compareTo(fullHouse)<0);
        assertTrue(fullHouse.compareTo(biggerFullHouse)<0);
        assertTrue(biggerFullHouse.compareTo(four)<0);
        assertTrue(four.compareTo(five)<0);
        assertTrue(five.compareTo(five)==0);
        assertTrue(five.compareTo(four)>0);
    }

    @Test
    void compare_hands_with_jokers() {
        Hand onePair = new Hand("32T3K 0");
        Hand twoPairs = new Hand("22T33 0");
        Hand onePairJoker = new Hand("3JT3K 0");
        Hand twoPairsJoker = new Hand("22J33 0");
        Hand three = new Hand("3QT33 0");
        Hand threeAndJoker = new Hand("3JT33 0");
        Hand threeAndTwoJokers = new Hand("3JJ33 0");
        Hand four = new Hand("33T33 0");
        Hand fullHouse = new Hand("3TT33 0");
        Hand biggerFullHouse = new Hand("3AA33 0");
        assertTrue(onePair.compareTo(onePairJoker)<0);
        assertTrue(onePairJoker.compareTo(twoPairs)>0);
        assertTrue(twoPairsJoker.compareTo(three)>0);
        assertTrue(twoPairsJoker.compareTo(fullHouse)<0);
        assertTrue(threeAndJoker.compareTo(biggerFullHouse)>0);
        assertTrue(threeAndTwoJokers.compareTo(four)>0);
    }
}