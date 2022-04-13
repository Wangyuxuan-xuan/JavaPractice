package AlgoExpert.BinaryTrees;

import java.util.ArrayList;

public class FindSuccessor {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(1);
        binaryTree.left.left.left = new BinaryTree(1);
        binaryTree.left.right = new BinaryTree(4);
        binaryTree.right = new BinaryTree(3);

        System.out.println(findSuccessor(binaryTree , binaryTree.left.right).value);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /**
     * O(n) time , O(n) space
     */
    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {

        ArrayList<BinaryTree> nodeInOrderTraversalOrder = new ArrayList<>();
        addInOrderTraversal(tree , nodeInOrderTraversalOrder);

        for (int i = 0; i < nodeInOrderTraversalOrder.size(); i++) {

            if (node.equals(nodeInOrderTraversalOrder.get(i))){
                if (i + 1 >= nodeInOrderTraversalOrder.size()){
                    return null;
                }
                return nodeInOrderTraversalOrder.get(i + 1);
            }
        }

        return null;
    }

    public static void addInOrderTraversal(BinaryTree node , ArrayList<BinaryTree> arrayList){

        if (node == null){
            return;
        }
        addInOrderTraversal(node.left , arrayList);
        arrayList.add(node);
        addInOrderTraversal(node.right, arrayList);
    }

    public static BinaryTree findSuccessorNotReady(BinaryTree tree, BinaryTree node) {

        boolean findTarget = false;
        return inOrderTraversal(tree , node,findTarget).result;
    }

    public static TargetStatus inOrderTraversal(BinaryTree node,BinaryTree target,boolean findTarget){

        if (node == null){
            return new TargetStatus(findTarget , null );
        }

        TargetStatus leftTreeResult = inOrderTraversal(node.left , target , findTarget);


        TargetStatus rightTreeResult = inOrderTraversal(node.right,target , findTarget);
        BinaryTree result = leftTreeResult.result == null ? rightTreeResult.result : leftTreeResult.result;
        findTarget = leftTreeResult.findTarget || rightTreeResult.findTarget;

        if (findTarget){
            return new TargetStatus(false , node);
        }
        if (node.equals(target)){
            findTarget = true;
        }

        return new TargetStatus(findTarget ,result );
    }

    static class TargetStatus {
        public boolean findTarget;
        public BinaryTree result;

        public TargetStatus(boolean findTarget, BinaryTree result) {
            this.findTarget = findTarget;
            this.result = result;
        }
    }
}
