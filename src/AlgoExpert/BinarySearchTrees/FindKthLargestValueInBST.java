package AlgoExpert.BinarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindKthLargestValueInBST {

    public static void main(String[] args) {

        BST bstTree = new BST(10);
        bstTree.left = new BST(8);
        bstTree.left.left = new BST(3);
        bstTree.left.right = new BST(9);
        bstTree.right = new BST(15);

        BST bstTree1 = new BST(1);
        bstTree1.right = new BST(2);
        bstTree1.right.right = new BST(3);
        bstTree1.right.right.right = new BST(4);
        bstTree1.right.right.right.right = new BST(5);

        System.out.println(findKthLargestValueInBstOptimize(bstTree1 , 5));
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
     * O(nlog(n)) time O(n) space
     */
    public static int findKthLargestValueInBst(BST tree, int k) {

        List<Integer> numbersInBST = new ArrayList<>();
        traversalBST(tree , numbersInBST);

        numbersInBST.sort(Comparator.reverseOrder());

        return numbersInBST.get(k -1);
    }

    public static void traversalBST(BST currentNode , List<Integer> list){

        if (currentNode == null){
            return;
        }

        list.add(currentNode.value);
        traversalBST(currentNode.left , list);
        traversalBST(currentNode.right , list);
    }


    public static int findKthLargestValueInBstOptimize(BST tree, int k) {

        CurrentNodeInfo largestNodeInfo = findLargestValueNode(tree , null);
        BST currentNode = largestNodeInfo.currentNode;
        BST parentNode = largestNodeInfo.parentNode;
        k--;
        while (k > 0){

            if (currentNode.left == null){
                currentNode = parentNode;
                parentNode = findParentNode(tree , currentNode);
            }else{
                CurrentNodeInfo currentNodeInfo = findLargestValueNode(currentNode.left , currentNode);
                currentNode = currentNodeInfo.currentNode;
                parentNode = currentNodeInfo.parentNode;
            }
            k--;
        }

        return currentNode.value;
    }
    public static CurrentNodeInfo findLargestValueNode(BST currentNode , BST parentNode){
        while (currentNode.right != null){
            parentNode = currentNode;
            currentNode = currentNode.right;
        }
        return new CurrentNodeInfo(currentNode , parentNode);
    }

    public static BST findParentNode(BST currentNode , BST inputNode){
        BST parentNode = null;
        while (currentNode != null){

            if (inputNode.value < currentNode.value){
                parentNode = currentNode;
                currentNode = currentNode.left;
            }else {
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
            if (currentNode == inputNode){
                break;
            }
        }
        return parentNode;
    }

    static class CurrentNodeInfo{
        BST currentNode ;
        BST parentNode ;

        public CurrentNodeInfo(BST currentNode, BST parentNode) {
            this.currentNode = currentNode;
            this.parentNode = parentNode;
        }
    }

}
