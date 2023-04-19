
public class MyStack<T>  implements MyStackInterface<T> {
    //add element to top 
    private static final int DEFAUT_CAP = 10;
    private int theSize; 
    private T[] myStacks;
    
    @SuppressWarnings ("unchecked")
    public MyStack() {
        myStacks =  (T[]) new Object[DEFAUT_CAP];
        theSize = 0;
    }

    //add
    public void push(T x){
        
        if (this.size() == myStacks.length){
            grow(myStacks.length*2);
        }
        //add element 
        myStacks[theSize++] = x;
        
    
    }

    //remove element from the top 
	public T pop(){

        if (this.isEmpty()){
            return null;
        }
        
        return myStacks[theSize--];

    }


    //look at the object at the top of this stack without removing it from the stack.
	public T peek(){

         if (this.isEmpty()){
            return null;
        }

        return myStacks[theSize-1];

    }

	public boolean isEmpty(){

        return this.size() == 0; 

    }
	public int size(){

        return theSize;

    }

    @SuppressWarnings ("unchecked")
    public void grow (int newCapacity){
        if (newCapacity <= theSize){
            return;
        }
        T[] newStack = (T[]) new Object[newCapacity]; 

        //copy old array to new 
        for (int i=0; i<theSize ; i++){
            newStack[i] = myStacks[i];
        }
        myStacks = newStack; 
    }


   


    
}