package AlgoExpert.BinarySearchTrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindKthLargestValueInBST {

    public static void main(String[] args) {

        BST bstTree = new BST(10);
        bstTree.left = new BST(8);
        bstTree.left.left = new BST(3);
        bstTree.left.right = new BST(9);
        bstTree.right = new BST(15);

//        BST bstTree1 = new BST(1);
//        bstTree1.right = new BST(2);
//        bstTree1.right.right = new BST(3);
//        bstTree1.right.right.right = new BST(4);
//        bstTree1.right.right.right.right = new BST(5);

        System.out.println(findKthLargestValueInBstReverseInOrderTraversal(bstTree , 3));
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    /**
     * O(n) time O(n) space
     *
     * we can actually use in order traversal here , it will add the node from left to right , which is a sorted array already
     */
    public static int findKthLargestValueInBst(BST tree, int k) {

        List<Integer> numbersInBST = new ArrayList<>();
        inOrderTraversalBST(tree , numbersInBST);

        return numbersInBST.get(numbersInBST.size() - k);
    }

    public static void inOrderTraversalBST(BST currentNode , List<Integer> list){

        if (currentNode == null){
            return;
        }

        inOrderTraversalBST(currentNode.left , list);
        list.add(currentNode.value);
        inOrderTraversalBST(currentNode.right , list);
    }


    /**
     * O(h + k) time , O(h) space
     */
    public static int findKthLargestValueInBstReverseInOrderTraversal(BST tree, int k) {

        VisitedNodeInfo visitedNodeInfo = new VisitedNodeInfo(0 , null);

        reverseInorderTraversal(tree,visitedNodeInfo,k);
        return visitedNodeInfo.lastVisitedNode.value;
    }

    public static void reverseInorderTraversal(BST currentNode , VisitedNodeInfo visitedNodeInfo , int k){

       if (currentNode == null || visitedNodeInfo.numOfVisitedNodes >= k ){
           return;
       }

       reverseInorderTraversal(currentNode.right , visitedNodeInfo , k);

       if (visitedNodeInfo.numOfVisitedNodes < k){
           visitedNodeInfo.numOfVisitedNodes += 1;
           visitedNodeInfo.lastVisitedNode = currentNode;
           reverseInorderTraversal(currentNode.left , visitedNodeInfo , k);
       }


    }

    static class VisitedNodeInfo{
        int numOfVisitedNodes ;
        BST lastVisitedNode;

        public VisitedNodeInfo(int numOfVisitedNodes, BST lastVisitedNode) {
            this.numOfVisitedNodes = numOfVisitedNodes;
            this.lastVisitedNode = lastVisitedNode;
        }
    }

    //todo  The space complexity of a recursion algorithm is  how many operation would we need to perform before we reach the base case
}
