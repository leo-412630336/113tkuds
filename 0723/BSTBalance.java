public class BSTBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class BalanceInfo {
        TreeNode node;
        int balanceFactor;
        BalanceInfo(TreeNode node, int bf) {
            this.node = node;
            this.balanceFactor = bf;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void printBalanceFactors(TreeNode root) {
        computeBalanceFactors(root);
    }

    private static int computeBalanceFactors(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = computeBalanceFactors(node.left);
        int rightHeight = computeBalanceFactors(node.right);
        int bf = leftHeight - rightHeight;
        System.out.println("節點 " + node.val + " 的平衡因子: " + bf);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static BalanceInfo mostUnbalanced = null;

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        mostUnbalanced = null;
        findUnbalanced(root);
        return mostUnbalanced == null ? null : mostUnbalanced.node;
    }

    private static int findUnbalanced(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = findUnbalanced(node.left);
        int rightHeight = findUnbalanced(node.right);
        int bf = leftHeight - rightHeight;

        if (mostUnbalanced == null || Math.abs(bf) > Math.abs(mostUnbalanced.balanceFactor)) {
            mostUnbalanced = new BalanceInfo(node, bf);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(3);
        root.right.right = new TreeNode(20);
        System.out.println("是否平衡樹？ " + isBalanced(root));

        System.out.println("各節點平衡因子：");
        printBalanceFactors(root);
        TreeNode worst = findMostUnbalancedNode(root);
        System.out.println("最不平衡節點為: " + (worst != null ? worst.val : "無"));
    }
}