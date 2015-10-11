import java.util.*;
import java.io.*;

public class testParser {

    public static void main(String[] args) {
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        HashMap<Character, Integer> punctuation = new HashMap<Character, Integer>();
        Scanner sc2 = null;
        Scanner wordScanner = null;
        Character c = null;
        String word = null;
        try {
            sc2 = new Scanner(new File("example.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
        while (sc2.hasNextLine()) {                
            String nextLine = sc2.nextLine();
            wordScanner = new Scanner(nextLine);
            while (wordScanner.hasNext()) {
                word = wordScanner.next();
                if (!Character.isLetter(word.charAt(0))) {
                    c = word.charAt(0);
                    if (!punctuation.containsKey(c)) {
                        punctuation.put(c, 0);
                    }
                    punctuation.put(c, punctuation.get(c) + 1);
                    word = word.substring(1, word.length());
                }
                if (word.length() >= 1 && !Character.isLetter(word.charAt(word.length() - 1))) { // may want to save word.length() to variable
                    c = word.charAt(word.length() - 1);
                    if (!punctuation.containsKey(c)) {
                        punctuation.put(c, 0);
                    }
                    punctuation.put(c, punctuation.get(c) + 1);
                    word = word.substring(0, word.length() - 1);
                }
            }
            if (!words.containsKey(word)) {
                words.put(word, 0);
            }
            words.put(word, words.get(word) + 1);  // industry standard
        }
        for (Character ch : punctuation.keySet()) {
            System.out.println(ch);
            System.out.println(punctuation.get(ch));
            System.out.println();
        }
    }
    
}