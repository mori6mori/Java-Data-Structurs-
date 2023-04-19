// stack to check if a word reversed is the same word 
@SuppressWarnings ("unchecked")
public class Palindrome implements PalindromeInterface{
    
    public Palindrome(){

    }
    
    public boolean isPalindrome(String x){

        MyStack<Character> word = new MyStack<Character>();
        x = x.replaceAll("\\s", "");
        x = x.toLowerCase(); 
        char[] wordArray = x.toCharArray();
        int length = x.length();
        int mid = length/2;
        System.out.println (mid);
        
        //adding char into the string 
        for (int i = 0; i < mid; i++){
            word.push(wordArray[i]);
        }
        
       //if the number of char is even 
        if (length % 2 == 0){
        
            for (int i = mid; i < length ; i++){

                char popped = word.peek();
                word.pop();
               
                if (popped != wordArray[i]){

                    return false;

                }

            }
        }
        //if the number of char is odd
        else{
            
            for (int i = mid+1 ; i < length; i++){
                
                char popped = word.peek();
                word.pop();
                
               if (popped != wordArray[i]){

                    return false;

               }
            }
        }
        
        
        return true;

    }
    
    
}