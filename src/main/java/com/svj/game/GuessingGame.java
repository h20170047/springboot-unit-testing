package com.svj.game;

import java.util.Random;

public class GuessingGame {
    private final int randNumber= new Random().nextInt(10);
    private int counter= 0;

    public String guess(int guessedNumber) {
        counter++;
        String tryText= counter>1?"tries":"try";
        String winningMsg = String.format("You got it in %d %s", counter, tryText);
        String response= null;
        if(counter== 4 && guessedNumber!= getRandomNumber()){
            response= String.format("You didn't get it and you've had %d %s. Game over.", counter, tryText);
        }else if(counter> 4){
            response= "Sorry, you are limited to only 4 tries. Your game is over.";
        }else{
            String hint= null;
            if(guessedNumber< getRandomNumber()){
                hint= "Try a larger number";
            }else{
                hint="Try a smaller number";
            }
            String loseMsg= String.format("You didn't get it. %s", hint);
            response= guessedNumber== getRandomNumber()? winningMsg : loseMsg;
        }
        return response;
    }

    public int getRandomNumber() {
        return randNumber;
    }

    // (Intellij hotkeys) ctrl+F9 to build, alt+F12 to open command prompt
    // java -cp target/classes com.svj.game.GuessingGame to run it in prompt
    public static void main(String[] args) {
        GuessingGame game= new GuessingGame();
        boolean loopShouldContinue = true;
        do{
            String input = System.console().readLine("Enter a number: ");
            if("q".equals(input)){
                return;
            }
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);
            if(output.contains("You got it") || output.contains("over")){
                loopShouldContinue= false;
            }
        }while (loopShouldContinue);

    }
}
