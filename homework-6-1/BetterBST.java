
import java.util.LinkedList;
import java.util.*;
import java.lang.Math;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>
{
    public int height(){
        return height(root);
    }
    private int height (BinaryNode<T> t){
        if (t == null){
            return -1;
        }
        int leftDepth = height(t.left);
        int rightDepth = height(t.right);

        return Math.max(leftDepth, rightDepth)+1;
    }

	public T imbalance(){

        return imbalance (root);

    }
    private T imbalance (BinaryNode<T> t){
        // at every node check if the difference of left and right is > 1 
        //int leftHeight = height(t.left);
        //int rightHeight = height(t.right); 
        int leftHeight = height(t.left);
        int rightHeight = height(t.right);
        if (t.left == null){
            leftHeight = -1;
        }else {
            leftHeight = height (t.left);
        }

        if (t.right == null){
            rightHeight = -1;
        }else {
            rightHeight = height (t.right);
        }
        
        if (Math.abs(leftHeight-rightHeight) > 1){
            //is imbalance
            return t.data; 
        }else{
            if (t.left != null){
                imbalance (t.left);
            }else if (t.right != null){
                imbalance (t.right);
            }else{
                return null;
            }
  
        }
        return null;
    }
	public T smallestGreaterThan(T t){
        return smallestGreaterThan(t, root);
    }
    private T smallestGreaterThan(T t, BinaryNode<T> rt){

        if (rt == null){
            return null;
        }

        if (t.compareTo(rt.data)>0 || t.compareTo(rt.data)==0 ){
            
            return smallestGreaterThan(t, rt.right);
            
        }else{
            if (rt.left != null){
                return smallestGreaterThan(t, rt.left);
            }else{
                return rt.data;
            }

        }
    
    }
 
    public BinarySearchTree<T> mirror(){

        BetterBST<T> newTree = new BetterBST<T> ();
        newTree.root = mirror(root, newTree);
        
        return (BinarySearchTree<T>)newTree;

    }
    
    
    private BinaryNode<T> mirror(BinaryNode<T> rt, BetterBST<T> tree){
        //base case 
        if (rt == null){
            return null;
        }
        
        BinaryNode<T> mirrorNode = new BinaryNode<T> (rt.data, mirror(rt.right, tree), mirror(rt.left, tree));
        return mirrorNode; 
        
    }

    

	public LinkedList<BinaryNode<T>> levelOrderTraversal(){
        
        
        return levelOrderTraversal(root);
    }
    private LinkedList<BinaryNode<T>> levelOrderTraversal(BinaryNode<T> rt){
        Queue<BinaryNode<T>> q = new LinkedList<BinaryNode<T>>();
        LinkedList<BinaryNode<T>> LinkedQue = new LinkedList<BinaryNode<T>> ();

        q.add(rt);

        while (!q.isEmpty()){
            BinaryNode<T> dequeued = q.remove();
            LinkedQue.add(dequeued);
            if (dequeued.left != null)
                q.add(dequeued.left);
            if (dequeued.right != null)
                q.add(dequeued.right);
        }
        return LinkedQue;
    }

}
