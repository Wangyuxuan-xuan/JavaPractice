package AlgoExpert.BinaryTrees;

public class BinaryTreeDiameter {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(1);
        binaryTree.left.left.left = new BinaryTree(1);
        binaryTree.left.right = new BinaryTree(4);
        binaryTree.right = new BinaryTree(3);

        System.out.println(binaryTreeDiameter(binaryTree));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /**
     * O(n) time , where n is the total number of elements in tree .
     * O(h) space , average case , where h is the height of the tree .
     * worst case can be O(n) , when the height = n , the tree is like a list .
     *
     * We have space in recursion because we need a recursive call stack
     * to hold all the recursive call that not yet finished
     *
     * The idea of this recursive algorithm is to find the diameter for current node
     * the diameter of a node can be the max diameter of its left or right tree ,
     * or the sum of height of its left and right tree .
     *
     * the height of a node is the max height of its left node or right node , and then plus 1
     */
    public static int binaryTreeDiameter(BinaryTree tree) {

        return getTreeInfo(tree).diameter;
    }

    public static TreeInfo getTreeInfo(BinaryTree node){

        if (node == null){
            return new TreeInfo(0,0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(node.left);
        TreeInfo rightTreeInfo = getTreeInfo(node.right);

        int diameter = Math.max(leftTreeInfo.height + rightTreeInfo.height, Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter));
        int height = Math.max(leftTreeInfo.height , rightTreeInfo.height) + 1;

        return new TreeInfo(diameter,height);
    }

    public static class TreeInfo{
        public int diameter;
        public int height;

        TreeInfo(int diameter,int height){
            this.diameter = diameter;
            this.height = height;
        }
    }
}
