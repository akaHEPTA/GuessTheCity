public class TempLab {

    String temp = "__________";
    char[] result = temp.toCharArray();


    public String myIndexOf(String tempAnswer, char letter) {
        while (tempAnswer.indexOf(letter) == -1) {
            int index = tempAnswer.indexOf(letter);
            result[index] = letter;
            tempAnswer = tempAnswer.substring(index + 1, tempAnswer.length());
        }

        return result.toString();
    }

}


