
import java.util.Stack;

public class TwoStackQueue<T> implements TwoStackQueueInterface<T>{
    
    //Enqueue, push on S1 
    private Stack<T> S1;
    //Dequeue, pop from S2 
    private Stack<T> S2;
    private int size;

    
    public TwoStackQueue (){

        S1 = new Stack<>();
        S2 = new Stack<>();
        
    }

    public void enqueue(T x){
        S1.push(x);
        size++;
    }

	public T dequeue(){

        if (S2.isEmpty()){
            while (!S1.isEmpty()){
                S2.push(S1.pop());
            }
        }

        if (S2.isEmpty()){
            return null;
        }

        T popped = S2.pop();
        size --; 
        return popped;
        
    }

	public int size(){
        return size;
    }

	public boolean isEmpty(){
        return size == 0;
    }


}