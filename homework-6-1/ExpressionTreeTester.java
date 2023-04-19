public class ExpressionTreeTester{

    public static void main (String args[]){

        ExpressionTree e = new ExpressionTree("2 3 4 + 5 6 * * +");
        
        System.out.println("prefix: " + e.prefix());
        System.out.println("postfix: " + e.postfix());
        System.out.println("infix: " + e.infix());
        System.out.println("eval: " + e.eval());

   
    }

}