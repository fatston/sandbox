import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Michelle {
    public static void main(String[] args) {
        System.out.println("Hello World");

        List<String> listOfWords = new ArrayList<>();

        try {
            listOfWords = getListOfWords();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        System.out.println(listOfWords);

        String input = "43556";
        String expected = "hello";
        List<String> actual = type(input);
        System.out.println("expected: " + expected + " actual: " + actual);
    }

    public static List<String> type(String integers) {
        List<String> possibleWords = new ArrayList<>();
        try {
            possibleWords = getListOfWords();
        } catch (Exception e) {
            System.out.println("Something went wrong getting the list of words in type method");
        }

        for (int i = 0; i < integers.length(); i++) {
            char number = integers.charAt(i);
            List<Character> possibleCharacters = charsFromNumber(number);
            possibleWords = getPossibleWords(i, possibleWords, possibleCharacters);
        }
        return possibleWords;
    }

    private static List<String> getPossibleWords(int index, List<String> possibleWords, List<Character> possibleCharacters) {
        return possibleWords.stream()
                .filter(w -> index < w.length() && possibleCharacters.contains(w.charAt(index)))
                .collect(Collectors.toList());
    }



    private static List<Character> charsFromNumber(char number) {
        // 2 - abc
        // 3 - def
        // 4 - ghi
        // 5 - jkl
        // 6 - mno
        // 7 - pqrs
        // 8 - tuv
        // 9 - wxyz

        switch(number) {
            case '2':
                return Arrays.asList('a','b','c');
            case '3':
                return Arrays.asList('d','e','f');
            case '4':
                return Arrays.asList('g','h','i');
            case '5':
                return Arrays.asList('j','k','l');
            case '6':
                return Arrays.asList('m','n','o');
            case '7':
                return Arrays.asList('p','q','r','s');
            case '8':
                return Arrays.asList('t','u','v');
            case '9':
                return Arrays.asList('w','x','y','z');
        }

        return new ArrayList<>();

    }

    public static List<String> getListOfWords() throws Exception {

        List<String> output = new ArrayList<>();
        // File path is passed as parameter
        File file = new File(
                "C:\\repo\\sandbox\\src\\dictionary.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            output.add(st);
        }
        return output;
    }
}
