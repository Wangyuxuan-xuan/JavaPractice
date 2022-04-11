package AlgoExpert.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BranchSums {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(10);
        binaryTree.left.left = new BinaryTree(11);
        binaryTree.right = new BinaryTree(2);

        List<Integer> arrayList = branchSums(binaryTree);
        System.out.println(arrayList.toString());
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {

       ArrayList<Integer> sums = new ArrayList<>();
       calculateBranchSum(root,0,sums);

        return sums;
    }

    public static void calculateBranchSum(BinaryTree node , int currentSum , ArrayList<Integer> sums){

        if (node == null){
            return;
        }

        currentSum += node.value;
        if (node.left == null && node.right == null){
            sums.add(currentSum);
            return;
        }
        calculateBranchSum(node.left,currentSum,sums);
        calculateBranchSum(node.right,currentSum,sums);

    }

    public static void LoopThroughBinaryTreeIterative(BinaryTree root){
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
