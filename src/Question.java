public class Question {
    private static final String[] SCRIPTS = {
            "Here's the Question.",                         // 0
            "---------",                                    // 1
            "Guess a letter: ",                             // 2
            "You are guessing: ",                           // 3
            "You have guessed (%d) wrong letters: ",        // 4
            "You Win!\nYou have guessed '%s' correctly.",   // 5
            "You lose!\nThe correct word was '%s'!"         // 6
    };
    private static final String ERROR_CODE = "[!] Script is not exist";

    private Question() {
    }

    public static String getScript(int scriptNum){
        if (scriptNum > 0 && scriptNum <= 6)
            return SCRIPTS[scriptNum];
        else
            return ERROR_CODE;
    }

}
