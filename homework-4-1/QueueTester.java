@SuppressWarnings("unchecked")
public class QueueTester{
    
    public static void main (String args[]){
        
        
        TwoStackQueue<String> q = new TwoStackQueue<String>();

        q.enqueue("tapis");
        q.enqueue("chien");
        
        System.out.println(q.isEmpty());
        System.out.println("deq: "+ q.dequeue());
        System.out.println(q.size());
        q.enqueue("talia");
        q.enqueue("mur");
        System.out.println("suppose to be 3:" + q.size());
        System.out.println("deq: "+ q.dequeue());
        System.out.println("deq: "+ q.dequeue());
        q.dequeue();
        System.out.println(q.size());
        System.out.println("empty: " + q.isEmpty());
        q.enqueue("mur");
        System.out.println(q.size());
        


    }
}