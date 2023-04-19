public class MyStackTester{
    public static void main (String[] args){

        MyStack<Character> number = new MyStack<Character>();
        
        number.push('z');
        number.push('b');
        number.push('d');
        number.pop();
        System.out.println (number.peek());
        System.out.println (number.pop());
    
    }
}