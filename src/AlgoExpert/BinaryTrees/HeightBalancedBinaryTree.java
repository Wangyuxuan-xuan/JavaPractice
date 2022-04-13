package AlgoExpert.BinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;

public class HeightBalancedBinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(1);
        binaryTree.left.left.left = new BinaryTree(1);
        binaryTree.left.left.left.left = new BinaryTree(0);
        binaryTree.left.right = new BinaryTree(4);
        binaryTree.right = new BinaryTree(3);

        System.out.println(heightBalancedBinaryTree(binaryTree));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static boolean heightBalancedBinaryTree(BinaryTree tree) {

        return traversalBinaryTree(tree).isBalanced;
    }

    public static TreeHeightInfo traversalBinaryTree(BinaryTree node){

        if(node == null){
            return new TreeHeightInfo(0, true);
        }

        TreeHeightInfo leftHeightInfo = traversalBinaryTree(node.left );
        TreeHeightInfo rightHeightInfo = traversalBinaryTree(node.right );

        int height = Math.max(leftHeightInfo.height, rightHeightInfo.height) + 1;
        boolean isBalanced =  Math.abs(leftHeightInfo.height - rightHeightInfo.height) <= 1;
        isBalanced = isBalanced && leftHeightInfo.isBalanced && rightHeightInfo.isBalanced;
        return new TreeHeightInfo(height,isBalanced);
    }

    static class TreeHeightInfo{
        int height;
        boolean isBalanced;

        public TreeHeightInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
