package AlgoExpert.BinarySearchTrees;

public class FindClosestValueInBST {

    public static void main(String[] args) {

        BST binaryTree = new BST(10);
        binaryTree.left = new BST(8);
        binaryTree.left.left = new BST(3);
        binaryTree.left.right = new BST(9);
        binaryTree.right = new BST(15);


        System.out.println(findClosestValueInBst(binaryTree, 4));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target) {

        return traversalBST(tree , Integer.MAX_VALUE , target);
    }

    public static int traversalBST(BST node , int min, int target){

        if (node == null){
            return min;
        }

        int currentDiff = Math.abs(node.value - target);
        if (currentDiff < min){
            min = currentDiff;
        }

        if (target < node.value){
            min = traversalBST(node.left , min , target);
        }

        min = traversalBST(node.right , min , target);

        return min;
    }

}
