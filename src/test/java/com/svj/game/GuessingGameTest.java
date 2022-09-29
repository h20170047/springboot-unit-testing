package com.svj.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessingGameTest{

    public static final int GAME_RANDOMNESS_RETRIES = 70;
    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation(){
        int randomNum= game.getRandomNumber();
        String message= game.guess(randomNum);
        assertEquals("You got it in 1 try", message);
    }

    @Test
    public void testOneWrongNegGuessSituation(){
        String message= game.guess(-5);
        assertEquals("You didn't get it. Try a larger number", message);
    }

    @Test
    public void testOneWrongPosGuessSituation(){
        int randomNum= game.getRandomNumber();
        String message= game.guess(randomNum+1);
        assertEquals("You didn't get it. Try a smaller number", message);
    }

    @Test
//    @RepeatedTest(5)
    public void testRandomNumberGeneration(){
        // 1 2 3 4 5 6 7 8 9 10
        // 1 1 1 1 0 1 0 1 1 1= 10
        int[] randomNumCount= new int[10];
        for(int counter = 0; counter< GAME_RANDOMNESS_RETRIES; counter++){
            GuessingGame localGame= new GuessingGame();
            int randomNum= localGame.getRandomNumber();
            randomNumCount[Math.abs(randomNum)%10]= 1;
        }
        int sum = Arrays.stream(randomNumCount).sum();
        assertEquals(10, sum);
    }

    @Test
    public void testFourWrongGuess(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("You didn't get it and you've had 4 tries. Game over.",message);
    }

    @Test
    public void testThreeWrongGuessesANdOneGuess(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        int correctAnswer= game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("You got it in 4 tries",message);
    }

    @Test
    public void testTwoWrongGuessesANdOneGuess(){
        game.guess(-3);
        game.guess(-3);
        int correctAnswer= game.getRandomNumber();
        String message = game.guess(correctAnswer);
//        assertEquals("You got it in 3 tries",message);
        assertTrue(message.contains("3"), "should indicate 2 tries");
        assertTrue(message.contains("You got it"), "should indicate that we got the right message");
    }

    @Test
    public void testTenWrongGuesseses(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("Sorry, you are limited to only 4 tries. Your game is over.",message);
    }
}
