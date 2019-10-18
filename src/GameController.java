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

        while(String.valueOf(guess).contains("_")) {
            if (wrongAnswerCount >= 10)
                break;
            checkGuess(getChar());
        }

        // 사용자 값 입력받아서 answer 와 비교
        // 매치 돌려서 존재할 경우 안 할 경우 쪼개기

        // Get Scanner input
        //System.out.print(Question.getScript(2)); // "Guess a letter: "

        // Check the input value exists in answer

        //System.out.print("\n" + Question.getScript(3)); // "You are guessing: "

        // 2. get scanner input
        // 3. if it is in answer -> update display and go to 1
        //    if it is not in answer -> update with the wrong answer list and show how may life left
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
    }

    private void generateFields(){
        answer = cities[myRandom.nextInt(99)].toCharArray();
        guess = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            guess[i] = answer[i] == ' ' ? ' ' : '_';
        wrongAnswers = new char[GUESS];
        wrongAnswerCount = 0;
    }

    private char getChar() {
        System.out.print(Question.getScript(2)); // "Guess a letter: "
        char input;
        while (true) {
            try {
                input = myScan.next().charAt(0);
                break;
            } catch (Exception e) {
                System.out.println("[!] Invalid Value: ");
                myScan = new Scanner(System.in);
            }
        }
        return input;
    }

    private void checkGuess(char input) {
        if (String.valueOf(answer).contains(String.valueOf(input))) {
            // 포함하고 있는걸 확인했으니 while 로 인덱스 조회하여 guess 업데이트
            for (int i = 0; i < answer.length; i++)
                if (answer[i] == input)
                    guess[i] = input;
        } else {
            // 포함하고 있지 않으니 오답 카운트++, 리스트에 추가
            wrongAnswers[wrongAnswerCount++] = input;
        }
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


}
