public class BSTKthElement {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class Result {
        int count = 0;
        int value = -1;  // 預設無結果
    }

    public static int findKthSmallest(TreeNode root, int k) {
        Result res = new Result();
        inOrderFind(root, k, res);
        return res.value;
    }
    private static void inOrderFind(TreeNode node, int k, Result res) {
        if (node == null || res.count >= k) return;

        inOrderFind(node.left, k, res);

        res.count++;
        if (res.count == k) {
            res.value = node.data;
            return;
        }

        inOrderFind(node.right, k, res);
    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.data) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);
        return root;
    }

    public static void main(String[] args) {
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        for (int k = 1; k <= 7; k++) {
            int result = findKthSmallest(root, k);
            System.out.println("第 " + k + " 小的元素是: " + result);
        }
    }
}