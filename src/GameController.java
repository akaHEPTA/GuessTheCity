import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class GameController {
    // Constants
    private static final int GUESS = 10;

    // Fields
    private Scanner myScan, fileScan;
    private Random myRandom;
    private File myFile;
    private String[] cities;
    private char[] answer;
    private char[] guess;
    private char[] wrongAnswers;
    private int wrongAnswerCount;

    // Constructors
    public GameController() {
        createObjects();
        readFile();
        generateFields();
        startGame();

        while(true) {
            if (wrongAnswerCount >= 10) {
                isLost();
                break;
            } else if (!String.valueOf(guess).contains("_")){
                isWin();
                break;
            }
            checkGuess(getChar());
            handleGuess();
        }

        System.out.println("\nDone!");
    }

    private void createObjects() {
        myScan = new Scanner(System.in);
        myRandom = new Random();
        myFile = new File("./src/cities.txt");
        try {
            fileScan = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }

    private void readFile(){
        cities = new String[100];
        int i = 0;
        while(fileScan.hasNextLine()) cities[i++] = fileScan.nextLine();
        fileScan.close();
    }

    private void generateFields(){
        answer = cities[myRandom.nextInt(99)].toCharArray();
        guess = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            guess[i] = answer[i] == ' ' ? ' ' : '_';
        wrongAnswers = new char[GUESS];
        wrongAnswerCount = 0;
    }

    private void startGame(){
        System.out.println(Question.getScript(0));
        System.out.println(String.valueOf(guess));
    }

    private char getChar() {
        char input;
        while (true) {
            System.out.print(Question.getScript(2)); // "Guess a letter: "
            try {
                String tempLine = myScan.nextLine();
                if (tempLine.length() > 1) throw new Exception();
                input = tempLine.charAt(0);
                break;
            } catch (Exception e) {
                myScan = new Scanner(System.in);
                handleGuess();
            }
        }
        return input;
    }

    private void checkGuess(char input) {
        if (String.valueOf(answer).contains(String.valueOf(input))) {
            for (int i = 0; i < answer.length; i++)
                if (answer[i] == input)
                    guess[i] = input;
        } else {
            wrongAnswers[wrongAnswerCount++] = input;
        }

    }

    private void handleGuess(){
        System.out.println(Question.getScript(3) + String.valueOf(guess));
        System.out.print(Question.getScript(4) + wrongAnswerCount
                + Question.getScript(5));
        String wrongAnswerList = "";
        for (char ch: wrongAnswers) {
            if (ch == '\u0000') break;
            wrongAnswerList += (ch + " ");
        }
        System.out.println(wrongAnswerList);
    }

    private void isLost() {
        System.out.println(Question.getScript(8) + String.valueOf(answer)
                + Question.getScript(9)); // "You lose!\nThe correct word was '%s'!"
    }

    private void isWin() {
        System.out.println(Question.getScript(6) + String.valueOf(answer)
                + Question.getScript(7)); // "' correctly."
    }

}
