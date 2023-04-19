public class SymbolBalanceTester{

    public static void main (String args[]){
        
        SymbolBalance s = new SymbolBalance();

        s.setFile("./TestFiles/Test6.java");

        System.out.println(s.checkFile());
    }
}