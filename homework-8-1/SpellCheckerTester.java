
import java.io.FileNotFoundException;
import java.util.*;
public class SpellCheckerTester{

    public static void main(String[] args) throws
        FileNotFoundException{

        SpellChecker checker = new SpellChecker("words.txt");
        List<String> incorrectWords = checker.getIncorrectWords("test.txt");
        

        //my suggestions returned are aggregated 
        for (int i = 0; i < incorrectWords.size(); i++){
           Set<String> suggestions = new HashSet<>();
           String wordIncorrect =  incorrectWords.get(i);
           System.out.println("incorrect: " + wordIncorrect);
           Set<String> newSuggestion = checker.getSuggestions(wordIncorrect);
           suggestions.addAll(newSuggestion);
           for (String s:suggestions){
              System.out.println(s);
           }
        }

        

    }


}