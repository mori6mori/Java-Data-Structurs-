public class Problem3{
    public static void main (String[] args){

       BigO test = new BigO ();

       long startTime = System.nanoTime();
       test.cubic(4);
       long endTime = System.nanoTime();
       System.out.println (endTime - startTime);
       
       startTime = System.nanoTime();
       test.exp(4);
       endTime = System.nanoTime();
       System.out.println (endTime - startTime);
      
       startTime = System.nanoTime();
       test.constant(4);
       endTime = System.nanoTime();
       System.out.println (endTime - startTime);
    

    }
}


    
