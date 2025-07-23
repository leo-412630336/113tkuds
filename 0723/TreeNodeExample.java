public class TreeNodeExample {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 印出樹狀圖，從右子樹開始，讓結構更直覺
    public static void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
            printTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        // 建立節點
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        // 建立樹的連結
        root.left = leftChild;
        root.right = rightChild;
        leftChild.left = node1;
        leftChild.right = node2;

        // 顯示整棵樹的圖形結構
        System.out.println("樹狀圖結構：\n");
        printTree(root, "", false);
    }
}