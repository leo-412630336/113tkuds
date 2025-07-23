public class TreeStatistics {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 計算所有節點值的總和
    public static int sum(TreeNode node) {
        if (node == null) return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    // 找出最大值
    public static int findMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.data, Math.max(findMax(node.left), findMax(node.right)));
    }

    // 找出最小值
    public static int findMin(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(node.data, Math.min(findMin(node.left), findMin(node.right)));
    }

    // 計算葉節點數量
    public static int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // 計算樹的高度（深度）
    public static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        // 建立一棵樹
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        // 輸出各種統計
        System.out.println("節點總和: " + sum(root));
        System.out.println("最大值: " + findMax(root));
        System.out.println("最小值: " + findMin(root));
        System.out.println("葉節點數: " + countLeaves(root));
        System.out.println("樹的高度: " + height(root));
    }
}