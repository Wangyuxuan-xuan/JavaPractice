package AlgoExpert.BinaryTrees;

import java.util.List;

public class NodeDepths {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(1);
        binaryTree.left.right = new BinaryTree(1);
        binaryTree.right = new BinaryTree(3);


        System.out.println(calculateTreeHeight(binaryTree ));
//        System.out.println(nodeDepths(binaryTree));
//        System.out.println(nodeDepthsBackTracking(binaryTree));
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {

        int sum = 0;
        int currentDepth = -1;
        sum= traversalBinaryTree(root,sum,currentDepth);

        return sum;
    }

    public static int traversalBinaryTree(BinaryTree node , int currentSum,int currentDepth){

        if(node == null){
            return currentSum;
        }
        currentDepth++;
        currentSum += currentDepth;

        currentSum = traversalBinaryTree(node.left ,currentSum,currentDepth);
        currentSum = traversalBinaryTree(node.right,currentSum ,currentDepth);

        return currentSum;
    }

    public static int nodeDepthsBackTracking(BinaryTree root) {

        int sum = 0;
        int currentDepth = 0;

        return calculateBranchDepth(root,currentDepth);
    }

    public static int calculateBranchDepth(BinaryTree node ,int currentDepth){

        if (node == null){
            return 0;
        }

        System.out.println(node.value + " : " + currentDepth);
        int left = calculateBranchDepth(node.left , currentDepth + 1);
        int right = calculateBranchDepth(node.right , currentDepth + 1);

        return currentDepth + left + right;
    }

    static int calculateTreeHeight(BinaryTree node ){

        if (node == null){
            return 0;
        }

        int leftTreeHeight = calculateTreeHeight(node.left );
        int rightTreeHeight = calculateTreeHeight(node.right);

        return Math.max(leftTreeHeight,rightTreeHeight) + 1;
    }
}
