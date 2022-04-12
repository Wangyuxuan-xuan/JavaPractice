package AlgoExpert.BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class InvertBinaryTrees {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(1);
        binaryTree.left.right = new BinaryTree(4);
        binaryTree.right = new BinaryTree(3);

        loopThroughBinaryTreeIterative(binaryTree);
        invertBinaryTree(binaryTree);
        System.out.println(" ");
        loopThroughBinaryTreeIterative(binaryTree);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null){
            return;
        }

        swap(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    public static void swap(BinaryTree tree){
       BinaryTree temp = tree.left;
       tree.left = tree.right;
       tree.right = temp;

    }

    /**
     * This swap is not working , should investigate why
     *
     * Java is always passing down a pointer , If our pointer still refer to the same object will caller function ,
     * we can access and modify it , if we assign a new object to it ,
     * it actually points to this new object and doesn't affect the object in caller method
     *
     * Here we pass down left pointer point to tree.left and right pointer point to tree.right
     * we change the left pointer point to right and right pointer point to left ,
     * but inside caller method , tree.left is till point to left and tree.right -> right too.
     * They doesn't change .
     *
     * But when passing down a tree object , since our pointer is point to tree object as the caller function does ,
     * we can change the tree.left and tree.right pointer in called method .
     */
    public static void swapNotWorking(BinaryTree left,BinaryTree right){
        BinaryTree temp = left;
        left = right;
        right = temp;
    }

    /**
     * A trick to swap in Java
     */
    public static int swap(int a , int b){
        return a; //todo    call like a = swap(b , b = a);
    }

    public static void invertBinaryTree1(BinaryTree tree) {
        if (tree == null){
            return;
        }
        ArrayList<BinaryTree> arrayList= swap1(tree.left,tree.right);
        tree.left = arrayList.get(0);
        tree.right = arrayList.get(1);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    /**
     * making copies , how could we swap variables ??
     */
    public static ArrayList<BinaryTree> swap1(BinaryTree left, BinaryTree right ){
        ArrayList<BinaryTree> arrayList = new ArrayList<>();
        BinaryTree temp = left;
        left = right;
        right = temp;
        arrayList.add(left);
        arrayList.add(right);
        return arrayList;

    }

    public static void loopThroughBinaryTreeIterative(BinaryTree root){
        Stack<BinaryTree> nodes = new Stack<BinaryTree>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            BinaryTree node = nodes.pop();
            if (node == null)
                continue;
            System.out.println(node.value);
            nodes.push(node.right);
            nodes.push(node.left);
        }
    }
}
