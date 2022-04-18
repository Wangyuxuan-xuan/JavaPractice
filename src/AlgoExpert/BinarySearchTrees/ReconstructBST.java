package AlgoExpert.BinarySearchTrees;

import java.util.ArrayList;

public class ReconstructBST {

    public static void main(String[] args) {

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
     * O(nlog(n)) time , O(1) space
     */
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {

        BST rootNode = new BST(preOrderTraversalValues.get(0));
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            insert(rootNode, preOrderTraversalValues.get(i));
        }

        return rootNode;
    }

    public void insert(BST currentNode , int value){
        while (true){
            if (value < currentNode.value){
                if (currentNode.left == null){
                    currentNode.left = new BST(value);
                    break;
                }
                currentNode = currentNode.left;

            }else {
                if(currentNode.right == null){
                    currentNode.right = new BST(value);
                    break;
                }
                currentNode = currentNode.right;
            }
        }
    }
    
}
