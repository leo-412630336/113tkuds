public class F12_TreeDiameter {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        calculateHeight(root);
        return diameter;
    }

    private static int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Diameter 1: " + diameterOfBinaryTree(root1)); 
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Diameter 2: " + diameterOfBinaryTree(root2));
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        root3.left.right.right = new TreeNode(6);
        System.out.println("Diameter 3: " + diameterOfBinaryTree(root3)); 
    }
}