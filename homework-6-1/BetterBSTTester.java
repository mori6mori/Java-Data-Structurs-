import java.util.LinkedList;
public class BetterBSTTester
{
    public static void main (String args[]){
        BetterBST<Integer> t = new BetterBST<Integer> ();
        //.  4
        // 2     6
        //1 3      7

        t.insert(4);
        t.insert(6);
        t.insert(2);
        t.insert(3);
        t.insert(1);
        t.insert(8);
        int h = t.height(); 
        BinarySearchTree<Integer> mirrorT = t.mirror(); 
        //.  4
        // 6.  2
        //8.  3 1
        //LinkedList<BinaryNode<Integer>> levelList = t.levelOrderTraversal();
//2
//null
//8
//8

        
        System.out.println("height: " + h);
        System.out.println("imbalanced node: " + t.imbalance());
        System.out.println("smallestGreaterThan: " + t.smallestGreaterThan(7));
        System.out.println("mirror: " + mirrorT.root.left.left.data);
        
        System.out.println("levelorder: " + t.levelOrderTraversal().get(0).data);
        System.out.println("levelorder: " + t.levelOrderTraversal().get(1).data);
        System.out.println("levelorder: " + t.levelOrderTraversal().get(2).data);
        System.out.println("levelorder: " + t.levelOrderTraversal().get(3).data);
        System.out.println("levelorder: " + t.levelOrderTraversal().get(4).data);
        System.out.println("levelorder: " + t.levelOrderTraversal().get(5).data);
        
        

        
    }
}