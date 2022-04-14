package AlgoExpert.BinarySearchTrees;

public class BSTConstruction {

    public static void main(String[] args) {
//        BST binaryTree = new BST(10);
//        binaryTree.left = new BST(5);
//        binaryTree.right = new BST(15);
//        binaryTree.left.left = new BST(2);
//        binaryTree.left.right = new BST(5);
//        binaryTree.left.left.left = new BST(1);
//        binaryTree.right.left = new BST(13);
//        binaryTree.right.right = new BST(22);
//        binaryTree.right.left.right = new BST(14);

        BST binaryTree = new BST(10);
        binaryTree.left = new BST(8);
        binaryTree.left.left = new BST(3);
//        binaryTree.left.left.left = new BST(1);
        binaryTree.left.right = new BST(9);
        binaryTree.right = new BST(15);

        System.out.println(binaryTree.insert(12));
        System.out.println(binaryTree.right.left.value);

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST currentNode = this;
            while (true){

                if (value < currentNode.value){
                    if (currentNode.left == null){
                        currentNode.left = new BST(value);
                        break;
                    }else {
                        currentNode = currentNode.left;
                    }
                }else {
                    if (currentNode.right == null){
                        //注意此处currentNode =  new BST() 不行， 仅left and right 为指针，我们要操作指针指向一个新leaf
                        currentNode.right = new BST(value);
                        break;
                    }
                    currentNode = currentNode.right;
                }
            }
            return this;
        }

        public boolean contains(int value) {

            BST currentNode = this;
            while (currentNode != null){

                if (value < currentNode.value){
                    currentNode = currentNode.left;
                }else if (value > currentNode.value){
                    currentNode = currentNode.right;
                }else {
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {
            BST currentNode = this;
            while (currentNode != null){

                if (value < currentNode.value){
                    currentNode = currentNode.left;
                }else if (value > currentNode.value){
                    currentNode = currentNode.right;
                }else {
                    currentNode = null;
                }
            }
            return this;
        }
    }
}
