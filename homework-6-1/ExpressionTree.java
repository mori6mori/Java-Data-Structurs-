import java.util.Stack;
import java.util.EmptyStackException;
public class ExpressionTree implements ExpressionTreeInterface{

    public ExpressionNode root;
    public boolean invalid = false;
    public ExpressionTree(String expression){
        
        String[] exp = expression.split("\\s+");
        Stack<ExpressionNode> stack = new Stack<ExpressionNode>();
        for (int i = 0; i < exp.length; i++){
            //if not operator, push to stack
           
            if (!exp[i].equals("+") && !exp[i].equals("-")&& !exp[i].equals("*")&& !exp[i].equals("/") ){
                try {
                    Integer.parseInt(exp[i]);
                }catch(NumberFormatException e){
                    invalid = true; 
                    System.out.println("Expression entered is invalid");
                }
                ExpressionNode operand = new ExpressionNode(exp[i], null, null); 
                stack.push(operand);

            }else{
               
                //if is operator, pop the first as right operand, next as left
                //create new expnode with operator and new left right
                ExpressionNode right = null;
                ExpressionNode left = null; 
                try{
                    right = stack.pop();
                    left = stack.pop(); 
                }catch(EmptyStackException e){
                    invalid = true;
                    System.out.println("Expression entered is invalid: extra operator");
                }  
            
                ExpressionNode operator = new ExpressionNode(exp[i], left, right);
                stack.push (operator);
                root = operator; 
            }
        }
        

    }

    
    public static class ExpressionNode {

        public String value;
        public ExpressionNode left;
        public ExpressionNode right;

        public ExpressionNode(String value, ExpressionNode left, ExpressionNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    //take string and build stack 
    

    // Return into result of evaluating the tree 
    public int eval(){
        if(root == null){
            throw new NullPointerException( );
        }
        return eval(root);

    }
    //recursive 
    private int eval (ExpressionNode rt){

        if (rt.value.equals("-")){
            return eval (rt.left) - eval (rt.right);
        }else if (rt.value.equals("+")){
            return eval (rt.left) + eval (rt.right);
        }else if (rt.value.equals("*")){
            return eval (rt.left) * eval (rt.right);
        }else if(rt.value.equals("/")){
            return eval (rt.left) / eval (rt.right);
        }else {
            return Integer.parseInt(rt.value);
        }
    }


    //no extra white space, one for each operand & operand 
    //return a string that contains postfix expression 
    public String postfix(){
        if (invalid){
            return null;
        }
        if(root == null)
            throw new NullPointerException( );
        
        return postfix(root);
    }

    private String postfix(ExpressionNode t){
        StringBuilder postfix = new StringBuilder(100);
        if (t.left == null && t.right == null){
            return t.value;
        }else if (t.value.equals("+")){
            postfix.append(postfix(t.left)+" " +postfix(t.right) +" "+  "+");
            return postfix.toString();
        }else if (t.value.equals("-") ){
            postfix.append(postfix(t.left)+" " + postfix(t.right) + " "+ "-");
            return postfix.toString();
        }else if (t.value.equals("*") ){
            postfix.append(postfix(t.left)+" " + postfix(t.right) +" "+  "*");
            return postfix.toString();
        }else /*(t.value.equals("/") )*/{
            postfix.append(postfix(t.left)+" " + postfix(t.right) +" "+  "/");
            return postfix.toString();
        }


    }

    // return prefix
    public String prefix(){
        if (invalid){
            return null;
        }
        if(root == null)
            throw new NullPointerException( );
        return prefix(root);
    }

    private String prefix(ExpressionNode t){
       
        StringBuilder prefix = new StringBuilder(100);
        
        if (t.left == null && t.right == null){
            return t.value;
        }else if (t.value.equals("+")){
            prefix.append("+" + " "+ prefix(t.left)+" "+prefix(t.right));
            return prefix.toString();
        }else if (t.value.equals("-") ){
            prefix.append("-" +" "+ prefix(t.left)+" "+ prefix(t.right));
            return prefix.toString();
        }else if (t.value.equals("*") ){
            prefix.append("*" + " "+prefix(t.left)+ " "+prefix(t.right));
            return prefix.toString();
        }else /*(t.value.equals("/"))*/{
            prefix.append("/" +" "+ prefix(t.left)+" "+ prefix(t.right));
            return prefix.toString();
        }

    }

    //return infix, include parenthesis 
    public String infix(){
        if (invalid){
            return null;
        }
        if(root == null)
            throw new NullPointerException( );
        return infix(root);

    }
    private String infix(ExpressionNode t){
        StringBuilder infix = new StringBuilder(100);
        
        if (t.left == null && t.right == null){
            return t.value;
        }else if (t.value.equals("+")){
            infix.append( "("+infix(t.left)+" "+  "+" +" "+ infix(t.right)+")");
            return infix.toString();
        }else if (t.value.equals("-") ){
            infix.append("("+infix(t.left)+ " "+ "-" +" "+ infix(t.right)+")");
            return infix.toString();
        }else if (t.value.equals("*") ){
            infix.append("("+infix(t.left)+ " "+ "*" + " "+ infix(t.right)+")");
            return infix.toString();
        }else /*if(t.value.equals("/") )*/{
            infix.append("("+infix(t.left)+" "+  "/" + " "+ infix(t.right)+")");
            return infix.toString();
        }

    }



}