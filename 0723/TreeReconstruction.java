import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // --- 1. 前序 + 中序 重建樹 ---
    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return buildPreIn(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPreIn(pre, preStart + 1, preStart + leftSize,
                               in, inStart, inRoot - 1, inMap);
        root.right = buildPreIn(pre, preStart + leftSize + 1, preEnd,
                                in, inRoot + 1, inEnd, inMap);
        return root;
    }

    // --- 2. 後序 + 中序 重建樹 ---
    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int postStart, int postEnd,
                                        int[] in, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPostIn(post, postStart, postStart + leftSize - 1,
                                in, inStart, inRoot - 1, inMap);
        root.right = buildPostIn(post, postStart + leftSize, postEnd - 1,
                                 in, inRoot + 1, inEnd, inMap);
        return root;
    }

    // --- 3. 驗證：印出中序遍歷來比對 ---
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // --- 主程式測試 ---
    public static void main(String[] args) {
        // 範例資料
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        System.out.println("由前序 + 中序重建的樹的中序遍歷：");
        TreeNode preInTree = buildTreePreIn(preorder, inorder);
        printInOrder(preInTree);  // 應該和 inorder 相同
        System.out.println();

        System.out.println("由後序 + 中序重建的樹的中序遍歷：");
        TreeNode postInTree = buildTreePostIn(postorder, inorder);
        printInOrder(postInTree);  // 應該和 inorder 相同
        System.out.println();
    }
}