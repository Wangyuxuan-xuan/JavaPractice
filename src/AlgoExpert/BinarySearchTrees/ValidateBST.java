package AlgoExpert.BinarySearchTrees;

public class ValidateBST {

    public static void main(String[] args) {

        BST bstTree = new BST(10);
        bstTree.left = new BST(8);
        bstTree.left.left = new BST(3);
//        binaryTree.left.left.left = new BST(1);
        bstTree.left.right = new BST(12);
//        bstTree.left.right = new BST(12);
        bstTree.right = new BST(15);

        System.out.println(validateBstByInterval(bstTree));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    /**
     * avg :  time complexity O(n) ? O(n*d) ? O(n*log(n)) ??? ,
     * O(d) space , where n is the number of nodes in BST tree and d is the depth of the tree
     */
    public static boolean validateBst(BST tree) {

        if (tree == null){
            return true;
        }

        boolean isValidLeft = validateBst(tree.left );
        boolean isValidRight = validateBst(tree.right);

        return isValidLeft && isValidRight && isCurrentNodeValid(tree);
    }

    public static boolean isCurrentNodeValid(BST currentNode){
        if (currentNode.left != null && currentNode.right != null){
            return getMaxNode(currentNode.left).value < currentNode.value && currentNode.value <= getMinNode(currentNode.right).value;
        }else if (currentNode.left != null){
            return getMaxNode(currentNode.left).value < currentNode.value;
        }else if(currentNode.right != null){
            return currentNode.value <= getMinNode(currentNode.right).value;
        }else return true;
    }

    public static BST getMaxNode(BST currentNode){
        while (currentNode.right != null){
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    public static BST getMinNode(BST currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }


    public static boolean validateBstByInterval(BST tree) {

        return validateBstByInterval(tree , Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean validateBstByInterval(BST currentNode , int minValue , int maxValue) {

       if (currentNode == null){
           return true;
       }

       boolean isValid = currentNode.value >= minValue && currentNode.value < maxValue;

        boolean isLeftValid = true;
        boolean isRightValid = true;
       if (currentNode.left != null){
           isLeftValid = validateBstByInterval(currentNode.left , minValue , currentNode.value);
       }
       if (currentNode.right != null){
           isRightValid = validateBstByInterval(currentNode.right , currentNode.value , maxValue);
       }

        return isValid && isLeftValid && isRightValid;
    }
}
