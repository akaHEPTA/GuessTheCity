import java.util.Random;
import java.util.Scanner;

public class GameController {
    private String answer = "";
    private Scanner myScan = null;
    private Random myRandom = null;
    private final String[] Cities = {"Chongqing", "Shanghai", "Beijing", "Lagos", "Mumbai", "Dhaka", "Chengdu", "Karachi",
            "Guangzhou", "Istanbul", "Tokyo", "Tianjin", "Moscow", "Sao Paulo", "Kinshasa", "Delhi", "Baoding",
            "Lahore", "Wuhan", "Cairo", "Seoul", "Jakarta", "Wenzhou", "Lima", "Mexico City", "London", "Bangkok",
            "Xian", "Chennai", "Bangalore", "New York", "Ho Chi Minh City", "Hyderabad", "Shenzhen", "Suzhou",
            "Nanjing", "Dongguan", "Tehran", "Quanzhou", "Shenyang", "Bogota", "Hong Kong", "Baghdad", "Fuzhou",
            "Changsha", "Hanoi", "Rio de Janeiro", "Qingdao", "Foshan", "Zunyi", "Santiago", "Riyadh", "Ahmedabad",
            "Singapore", "Shantou", "Ankara", "Yangon", "Saint Petersburg", "Sydney", "Casablanca", "Melbourne",
            "Abidjan", "Alexandria", "Kolkata", "Surat", "Johannesburg", "Dar es Salaam", "Shijiazhuang", "Harbin",
            "Giza", "İzmir", "Zhengzhou", "Taipei", "Los Angeles", "Berlin", "Busan", "Madrid", "Buenos Aires",
            "Toronto", "Chicago", "Osaka", "Paris", "Vancouver", "Montreal", "San Francisco", "Boston", "Seattle",
            "Washington DC", "Philadelphia", "Portland", "Ottawa", "Miami", "Dallas", "Calgary", "Denver", "Detroit",
            "Houston", "Edmonton", "Las Vegas", "Atlanta"
    };

    public GameController() {
        // Create objects
        myScan = new Scanner(System.in);
        myRandom = new Random();

        // Random generate answer
        answer = Cities[myRandom.nextInt(99)];

        // myAnswer generator
        //* char type underscore converter
        char[] guess = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++)
            guess[i] = answer.toCharArray()[i] == ' ' ? ' ' : '_';
        guess.toString();

        //*/

        /* String type underscore converter
        String myAnswer;
        for (char ch: answer.toCharArray())
            myAnswer += ch == ' ' ? ' ' : '_';
        //*/

        // Get Scanner input
        System.out.print(Question.getScript(2)); // "Guess a letter: "
        char input = getChar();

        // Check the input value exists in answer
        while (answer.indexOf(input) == -1) {

            //myAnswer.indexOf(input);
        }

        System.out.print("\n" + Question.getScript(3)); // "You are guessing: "

        // 0. pick one of the cities
        // 1. show the underscores
        // 2. get scanner input
        // 3. if it is in answer -> update display and go to 1
        //    if it is not in answer -> update with the wrong answer list and show how may life left
    }

    private String myIndexOf(String tempAnswer, char letter) {
        char[] result = new char[tempAnswer.length()];

        while(tempAnswer.indexOf(letter) == -1) {
            int index = tempAnswer.indexOf(letter);
            result[index] = letter;
            tempAnswer = tempAnswer.substring(index + 1, tempAnswer.length());
        }
        return "";
    }



    private char getChar() {

        char input;

        while (true) {
            try {
                input = myScan.next().charAt(0);
                break;
            } catch (Exception e) {
                System.out.println("[!] System : ");
                myScan = new Scanner(System.in);
            }
        }

        return input;
    }


}
