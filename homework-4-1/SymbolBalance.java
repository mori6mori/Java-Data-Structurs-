import java.util.Stack; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolBalance implements SymbolBalanceInterface {
    //takes the filename, the path to the file be checked
   
    private Scanner in = null;
    private Stack <Character> symbols = new Stack<Character> ();
    private int lineNumber;

    public void setFile(String filename){
        File f = new File(filename);
        try {
	        in = new Scanner(f);
        }catch (FileNotFoundException exp){
	        System.err.println("Could noy open file: " + filename);
	        System.exit(-1); 
        }

    }

    public BalanceError checkFile(){
        boolean notCheck = false;
        while (in.hasNextLine()){
            lineNumber ++;
            String line = in.nextLine();
            
            for (int i = 0; i < line.length(); i++){
                
                char currentSymbol = line.charAt(i);
                char symbolPopped; 

                if (i > 0){
                    if (currentSymbol == '*' && line.charAt(i-1) == '/' && notCheck == false ){
                        notCheck = true; 
                        symbols.push(currentSymbol);
                        continue;  
                    }else if (currentSymbol == '/' && line.charAt(i-1) == '*' && notCheck == true){
                        
                        if (!symbols.isEmpty()){
                            if (symbols.peek() == '*'){
                                symbolPopped = symbols.pop();
                                notCheck = false; 
                                continue; 
                            }else{
                                symbolPopped = symbols.pop();
                                notCheck = false; 
                                MismatchError m = new MismatchError( lineNumber,  currentSymbol , symbolPopped);
                                return m;
                            }
                        }else{
                            EmptyStackError e = new EmptyStackError(lineNumber);
                            return e;
                        }
                    }
                }
              
                if (notCheck == false && currentSymbol == '"' && symbols.peek()!='"'){
                    notCheck = true; 
                    symbols.push(currentSymbol);
                    continue;  
                    //missing closing " situation?
                }else if( notCheck == true && currentSymbol == '"' && symbols.peek()=='"'){
                    symbolPopped = symbols.pop();
                    notCheck = false; 
                    continue;  
                }
                
                if (!notCheck){
                    
                    if (currentSymbol == '{'|| currentSymbol == '['|| currentSymbol =='('){
                        symbols.push(currentSymbol);
                        //print pushed 
                        //System.out.println("pushed: " + String.valueOf (currentSymbol)); 
                        continue;
                    }

                    if (currentSymbol == '}'|| currentSymbol == ']'|| currentSymbol ==')'){
                        
                        if (!symbols.isEmpty()){
                            symbolPopped = symbols.pop(); 
                            //print popped 
                            //System.out.println("popped: " + String.valueOf (symbolPopped)); 
                        }else{
                            EmptyStackError e = new EmptyStackError (lineNumber);
                            return e;
                        }

                        if ( (currentSymbol == '}' && symbolPopped != '{')|| (currentSymbol == ']' && symbolPopped != '[')||(currentSymbol == ')' && symbolPopped != '(')){
                            
                             
                            //System.out.println("mismatched: " + symbolPopped + "line: " + lineNumber); 
                            MismatchError m = new MismatchError (lineNumber,  currentSymbol , symbolPopped );
                            return m;

                        }

                    }
                }
            }
        }
        if (!symbols.isEmpty()){
            int size = symbols.size();
            char top = symbols.peek();
            NonEmptyStackError n = new NonEmptyStackError(top, size); 
            System.out.println (top + " " +size);
            return n;
        }

        in.close();

        return null;

    } 
    
    
    
    
    // returns either MismatchError(int lineNumber, char currentSymbol, char symbolPopped)
					 //                EmptyStackError(int lineNumber), 
					 //                NonEmptyStackError(char topElement, int sizeOfStack). 
					 // All three classes implement BalanceError
}