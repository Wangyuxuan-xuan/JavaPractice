package AlgoExpert.BinarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static void main(String[] args) {
        minHeightBst(new ArrayList<>(Arrays.asList(1,2,5,7,10,13,14,15,22)));
    }

    public static BST minHeightBst(List<Integer> array) {

        return constructMinHeightBst(null , array , 0 , array.size() - 1);
    }

    /**
     * O(nlog(n)) time O(n) space
     */
    public static BST constructMinHeightBst( BST currentTree, List<Integer> list , int startIdx , int endIdx){

        if (startIdx > endIdx){
            return null;
        }
        int middleIdx = (startIdx + endIdx) /2 ;
        if (currentTree == null){
            currentTree = new BST(list.get(middleIdx));
        }else {
            currentTree.insert(list.get(middleIdx));
        }

        constructMinHeightBst(currentTree , list , startIdx , middleIdx - 1);
        constructMinHeightBst(currentTree , list , middleIdx + 1, endIdx);


        return currentTree;
    }

    public static BST minHeightBstWithoutCallingInsert(List<Integer> array) {

        return minHeightBstWithoutCallingInsert( array , 0 , array.size() - 1);
    }

    /**
     * O(n) time O(n) space 
     */
    public static BST minHeightBstWithoutCallingInsert(List<Integer> array ,int startIdx , int endIdx) {

        int middleIdx = (startIdx + endIdx ) / 2 ;
        if (startIdx > endIdx ) return null;
        BST currentNode = new BST(array.get(middleIdx));

        currentNode.left = minHeightBstWithoutCallingInsert(array , startIdx , middleIdx - 1);
        currentNode.right = minHeightBstWithoutCallingInsert(array , middleIdx + 1, endIdx);

        return currentNode;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
