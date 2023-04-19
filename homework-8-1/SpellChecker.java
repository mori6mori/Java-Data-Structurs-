import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.HashSet; 
//address edge case with substring 
public class SpellChecker implements SpellCheckerInterface{

    private List<String> list = new ArrayList<String>();
    private HashSet<String> dichash = new HashSet<String>();

    public SpellChecker( String filename ){
        
        //file to be checked 
        File inFile = new File(filename);
        Scanner in = new Scanner ("new");

        try{
            in  = new Scanner( inFile ); 
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }

    
        while (in.hasNextLine()){
            //and array of words after it is cleaned and parsed 
            String line = in.nextLine();
            String[] words = line.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
           //add to hashset dic 
            for (int i= 0; i < words.length; i++){
                dichash.add(words[i]);
            }

            
        }
    }
   /* public void getPrint (){
        for (int i= 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }*/

    //return list of words in input that is incorrect according to dic 
    public List<String> getIncorrectWords(String filename){
        HashSet<String> wordhash = new HashSet<String>();
        List<String> incorrect = new ArrayList<>();
        
        //file to be checked 
        File inFile = new File(filename);
        Scanner in = new Scanner ("new");
        try{
            in  = new Scanner( inFile ); 
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        while (in.hasNextLine()){
            //and array of words after it is cleaned and parsed 
            String line = in.nextLine();
            String[] words = line.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
           //add to hashset dic 
            for (int i= 0; i < words.length; i++){
                wordhash.add(words[i]);
            }
        }

        //if wordhash has no match in dichash then insert that word into List incorrect 
        boolean isCorrect = true; 
        for (String s : wordhash){
            // is this okay?
            if (!this.dichash.contains(s)){
                incorrect.add(s);
            }
        }

        for (int i = 0; i<incorrect.size(); i++){
            System.out.println(incorrect.get(i));
        }
        

        return incorrect;
    }

    public Set<String> getSuggestions(String word){
        Set<String> suggestions = new HashSet<>();
        String suggest = null;
        //parse each word into chars
        //complete each suggestion, convert back to String, insert into set
        //check with dicHash, see if it is valid 
        ArrayList<Character> charList = new ArrayList<Character>();
        for (int i = 0; i< word.length(); i++){
            charList.add(word.charAt(i));
        }
        
        /*ArrayList<Character> charList3 = new ArrayList<Character>();
        for (int n = 0; n < charList.size(); n++){
            charList3.add(charList.get(n));
        }*/

        //add char
        /*for(char al = 'a'; al <='z'; al ++ ){

            char alphabet= al;

            for (int i = 0; i < charList3.size()+1; i++){
                charList3.add(i, alphabet);
                StringBuilder stringBuilder = new StringBuilder(charList3.size());
                for (char c : charList3){     
                    stringBuilder.append(c);
                }
                String suggest = stringBuilder.toString();
                if (this.dichash.contains(suggest)){
                    suggestions.add(suggest);
                }
                charList3.remove(i);
            }
        }*/
        for(char al = 'a'; al <='z'; al ++ ){

            char newChar= al;
            for (int i = 0; i< word.length()+1; i++){
                suggest = word.substring(0, i) + newChar + word.substring(i);
                if (this.dichash.contains(suggest)){
                    suggestions.add(suggest);
                }
                //word = suggest.substring(0, index) + suggest.substring(index+1)
            }
        }

        for (int i = 0; i< word.length(); i++){
            suggest = word.substring(0, i) + word.substring(i+1);
            if (this.dichash.contains(suggest)){
                suggestions.add(suggest);
            }


        }

        for (int i = 0; i < word.length() - 1; i++) {
            suggest = word.substring(0, i) + word.substring(i + 1, i + 2) + 
                word.substring(i, i + 1) + word.substring(i + 2);
            if (this.dichash.contains(suggest)){
                suggestions.add(suggest);
            }
        }
        /*
        //remove char
        for (int i = 0; i< charList.size(); i++){

            ArrayList<Character> charList2 = new ArrayList<Character>();
            for (int n = 0; n < charList.size(); n++){
                charList2.add(charList.get(n));
            }
            charList2.remove(i);
            StringBuilder stringBuilder = new StringBuilder(charList2.size());
            for (char c : charList2){     
                stringBuilder.append(c);
            }
            String suggest = stringBuilder.toString();
            if (this.dichash.contains(suggest)){
                suggestions.add(suggest);
            }
        }

        //swap char
        for (int i = 0; i< charList.size()-1; i++){

            ArrayList<Character> charList2 = new ArrayList<Character>();
            for (int n = 0; n < charList.size(); n++){
                charList2.add(charList.get(n));
            }

            char temp = charList2.get(i+1);
            charList2.set(i+1, charList2.get(i));
            charList2.set(i, temp);

            StringBuilder stringBuilder = new StringBuilder(charList2.size());
            for (char c : charList2){     
                stringBuilder.append(c);
            }
            String suggest = stringBuilder.toString();
            if (this.dichash.contains(suggest)){
                suggestions.add(suggest);
            }
            
        }
        */

        return suggestions;
    }
    

}