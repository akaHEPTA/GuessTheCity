import java.util.Arrays;

public class TempLab {

    String temp = "__________";
    char[] result = temp.toCharArray();

    public String myIndexOf(String tempAnswer, char letter) {

        while (tempAnswer.indexOf(letter) != -1) {
            int index = tempAnswer.indexOf(letter);
            result[index] = letter;
            tempAnswer = tempAnswer.substring(index + 1);
        }


        return String.valueOf(result);
    }

    public String myIndexOf2(String tempAnswer, char letter) {
        if (tempAnswer.indexOf(letter) == -1)
            return tempAnswer;
        else {
            result[tempAnswer.indexOf(letter)] = letter;
            return String.valueOf(result).substring(0, tempAnswer.indexOf(letter)) + myIndexOf2(tempAnswer.substring(tempAnswer.indexOf(letter)), letter);
        }
    }


}


