public class Question {
    private static final String[] SCRIPTS = {
            "Here's the Question.",                         // 0
            "---------",                                    // 1 - not used
            "Guess a letter: ",                             // 2
            "You are guessing: ",                           // 3
            "You have guessed (",                           // 4
            ") wrong letters: ",                            // 5
            "You Win!\nYou have guessed '",                 // 6
            "' correctly.",                                 // 7
            "You lose!\nThe correct word was '",            // 8
            "'!"                                            // 9
    };

    private static final String ERROR_CODE = "[!] Script is not exist";

    private Question() {
    }

    public static String getScript(int scriptNum){
        if (scriptNum >= 0 && scriptNum < SCRIPTS.length)
            return SCRIPTS[scriptNum];
        else
            return ERROR_CODE;
    }

}

/*
 Backup code

    private static final String[] CITIES = {"Chongqing", "Shanghai", "Beijing", "Lagos", "Mumbai", "Dhaka", "Chengdu",
            "Karachi", "Guangzhou", "Istanbul", "Tokyo", "Tianjin", "Moscow", "Sao Paulo", "Kinshasa", "Delhi",
            "Baoding", "Lahore", "Wuhan", "Cairo", "Seoul", "Jakarta", "Wenzhou", "Lima", "Mexico City", "London",
            "Bangkok", "Xian", "Chennai", "Bangalore", "New York", "Ho Chi Minh City", "Hyderabad", "Shenzhen",
            "Suzhou", "Nanjing", "Dongguan", "Tehran", "Quanzhou", "Shenyang", "Bogota", "Hong Kong", "Baghdad",
            "Fuzhou", "Changsha", "Hanoi", "Rio de Janeiro", "Qingdao", "Foshan", "Zunyi", "Santiago", "Riyadh",
            "Ahmedabad", "Singapore", "Shantou", "Ankara", "Yangon", "Saint Petersburg", "Sydney", "Casablanca",
            "Melbourne", "Abidjan", "Alexandria", "Kolkata", "Surat", "Johannesburg", "Dar es Salaam", "Shijiazhuang",
            "Harbin", "Giza", "İzmir", "Zhengzhou", "Taipei", "Los Angeles", "Berlin", "Busan", "Madrid",
            "Buenos Aires", "Toronto", "Chicago", "Osaka", "Paris", "Vancouver", "Montreal", "San Francisco", "Boston",
            "Seattle", "Washington DC", "Philadelphia", "Portland", "Ottawa", "Miami", "Dallas", "Calgary", "Denver",
            "Detroit", "Houston", "Edmonton", "Las Vegas", "Atlanta"
    };


    private String myIndexOf(String tempAnswer, char letter) {
        char[] result = new char[tempAnswer.length()];

        while (tempAnswer.indexOf(letter) == -1) {
            int index = tempAnswer.indexOf(letter);
            result[index] = letter;
            tempAnswer = tempAnswer.substring(index + 1);
        }
        return "";
    }

    private int update(char letter) {
        int cnt = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == letter) {
                guess[i] = letter;
                cnt++;
            }
        }
        return cnt;
    }
*/