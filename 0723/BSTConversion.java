public class BSTConversion {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode prev = null;
    static TreeNode head = null;

    public static TreeNode bstToDoublyList(TreeNode root) {
        prev = null;
        head = null;
        convertToDoublyList(root);
        return head;
    }

    private static void convertToDoublyList(TreeNode node) {
        if (node == null) return;
        convertToDoublyList(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        convertToDoublyList(node.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBalancedBST(arr, left, mid - 1);
        root.right = buildBalancedBST(arr, mid + 1, right);
        return root;
    }

    static int sum = 0;

    public static void convertBSTtoGreaterTree(TreeNode root) {
        sum = 0;
        reverseInOrder(root);
    }

    private static void reverseInOrder(TreeNode node) {
        if (node == null) return;
        reverseInOrder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInOrder(node.left);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void printDoublyList(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        TreeNode listHead = bstToDoublyList(root);
        System.out.print("雙向鏈表結果：");
        printDoublyList(listHead);

        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        TreeNode balancedBST = sortedArrayToBST(sorted);
        System.out.print("中序遍歷平衡 BST：");
        printInOrder(balancedBST);
        System.out.println();

        convertBSTtoGreaterTree(balancedBST);
        System.out.print("轉換為 Greater Tree 的中序遍歷：");
        printInOrder(balancedBST);
        System.out.println();
    }
}