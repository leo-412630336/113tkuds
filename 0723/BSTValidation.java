import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max))
            return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findInvalid(root, new TreeNodeWrapper(), result);
        return result;
    }

    private static class TreeNodeWrapper {
        TreeNode prev = null;
    }

    private static void findInvalid(TreeNode node, TreeNodeWrapper prevWrapper, List<Integer> invalidNodes) {
        if (node == null) return;
        findInvalid(node.left, prevWrapper, invalidNodes);

        if (prevWrapper.prev != null && node.val <= prevWrapper.prev.val) {
            invalidNodes.add(node.val);
        }
        prevWrapper.prev = node;

        findInvalid(node.right, prevWrapper, invalidNodes);
    }

    public static int minNodesToRemove(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);

        List<Integer> lis = new ArrayList<>();
        for (int val : inorder) {
            int idx = Collections.binarySearch(lis, val);
            if (idx < 0) idx = -(idx + 1);
            if (idx == lis.size()) {
                lis.add(val);
            } else {
                lis.set(idx, val);
            }
        }
        return inorder.size() - lis.size();
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }

    public static void main(String[] args) {
   
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(20);

        System.out.println("是否為合法 BST？ " + isValidBST(root));

        List<Integer> invalid = findInvalidNodes(root);
        System.out.println("違規節點值: " + invalid);

        int minRemove = minNodesToRemove(root);
        System.out.println("需移除節點數使其為合法 BST: " + minRemove);
    }
}