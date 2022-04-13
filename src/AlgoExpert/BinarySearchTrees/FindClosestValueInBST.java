package AlgoExpert.BinarySearchTrees;

public class FindClosestValueInBST {

    public static void main(String[] args) {

        BST binaryTree = new BST(10);
        binaryTree.left = new BST(5);
        binaryTree.right = new BST(15);
        binaryTree.left.left = new BST(2);
        binaryTree.left.right = new BST(5);
        binaryTree.left.left.left = new BST(1);
        binaryTree.right.left = new BST(13);
        binaryTree.right.right = new BST(22);
        binaryTree.right.left.right = new BST(14);



        System.out.println(findClosestValueInBst(binaryTree, 12));
        System.out.println(findClosestValueInBstIterative(binaryTree,12));
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

        return traversalBSTRecursion(tree , Integer.MAX_VALUE , target) + target;
    }

    public static int traversalBSTRecursion(BST node , int min, int target){

        if (node == null){
            return min;
        }

        int currentDiff = node.value - target;
        if (Math.abs(currentDiff) < Math.abs(min)){
            min = currentDiff;
        }

        if (target < node.value){
            return traversalBSTRecursion(node.left , min , target);
        }

        return traversalBSTRecursion(node.right , min , target);

    }


    public static int findClosestValueInBstIterative(BST tree, int target) {

        BST currentNode =  tree;
        int closest = tree.value;
        while (currentNode != null){
            if (Math.abs(currentNode.value - target) < Math.abs(closest - target)){
                closest = currentNode.value;
            }
            if (target < currentNode.value){
                currentNode = currentNode.left;
            }else if(target > currentNode.value){
                currentNode = currentNode.right;
            }else {
                return closest; //save calculation
            }
        }
        return closest;
    }
}
