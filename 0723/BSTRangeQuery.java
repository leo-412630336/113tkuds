import java.util.ArrayList;

public class BSTRangeQuery {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 插入節點（建立 BST 用）
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // 範圍查詢，回傳排序後的 ArrayList
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    // 中序遍歷 + 範圍條件判斷
    private static void inOrderRange(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        if (node.data > min) {
            inOrderRange(node.left, min, max, result);
        }

        if (node.data >= min && node.data <= max) {
            result.add(node.data);
        }

        if (node.data < max) {
            inOrderRange(node.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        // 建立 BST：[20, 10, 30, 5, 15, 25, 35]
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        // 查詢範圍 [12, 27]
        int min = 12, max = 27;
        ArrayList<Integer> result = rangeQuery(root, min, max);
        System.out.println("範圍 [" + min + ", " + max + "] 內的節點值為: " + result);
    }
}