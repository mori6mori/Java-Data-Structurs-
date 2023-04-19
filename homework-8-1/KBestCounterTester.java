
import java.util.*;

public class KBestCounterTester {
    public static void main (String[] args){

        KBestCounter<Integer> counter = new KBestCounter<>(2);

        counter.count(8);
        counter.count(5);
        counter.count(10);
        counter.count(1000);

        List<Integer> largeValue = counter.kbest();

        for (int i =0; i < largeValue.size(); i++){
            System.out.println(largeValue.get(i));
        }
        
        System.out.println("2nd round");
        
        List<Integer> largeValue2 = counter.kbest();

        for (int i =0; i < largeValue2.size(); i++){
            System.out.println(largeValue2.get(i));
        }


    }
}