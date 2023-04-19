import java.util.PriorityQueue;
import java.util.*;
import java.util.Iterator;
public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
//keeps the k-largest element seen so far in sequence of data 
    
    private int count;
    private int maxK;

    PriorityQueue<T> pQ = new PriorityQueue<T>(); 

    public KBestCounter(int k){
        // k = amount of largest element 
        maxK = k;
        
    }
    
    //process the next element in a dataset, (worst O(log k))
    public void count (T x){
        if (pQ.peek()==null){
            pQ.offer(x);
            count++;
        }else if (x.compareTo(pQ.peek())>0 ){
            if (count < maxK){
                pQ.offer(x);
                count++;
            }else{
                //delete highest priority (smallest in the pQ)
                pQ.poll();
                pQ.offer(x);
            }
            
        }


        //keep the max as lowest priority, remove highest priority 

        //if is larger and insert 
       

    }

    //return sorted list of K-largest , worst O(log k) 
    //ASCENDING?? 
    //if run twice should return same value 
    public List<T> kbest (){

        List<T> largests = new ArrayList<>();

        /*while (!pQ.isEmpty()){
            largests.add(pQ.poll());
        }*/
        Iterator<T> iterate = pQ.iterator();
        while(iterate.hasNext()) {
            largests.add(iterate.next());
        }

        return largests;

    }
}