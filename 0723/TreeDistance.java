import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    private static int distanceFromRoot(TreeNode root, TreeNode target, int dist) {
        if (root == null) return -1;
        if (root == target) return dist;
        int left = distanceFromRoot(root.left, target, dist + 1);
        if (left != -1) return left;
        return distanceFromRoot(root.right, target, dist + 1);
    }

    public static int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        int distP = distanceFromRoot(lca, p, 0);
        int distQ = distanceFromRoot(lca, q, 0);
        return distP + distQ;
    }
    static int diameter = 0;

    public static int treeDiameter(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static List<TreeNode> nodesAtDistanceK(TreeNode root, int k) {
        List<TreeNode> result = new ArrayList<>();
        findNodesAtDistanceK(root, k, result);
        return result;
    }

    private static void findNodesAtDistanceK(TreeNode node, int k, List<TreeNode> res) {
        if (node == null) return;
        if (k == 0) {
            res.add(node);
            return;
        }
        findNodesAtDistanceK(node.left, k - 1, res);
        findNodesAtDistanceK(node.right, k - 1, res);
    }

    public static void main(String[] args) {
     
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode node4 = root.left.left;
        TreeNode node5 = root.left.right;
        TreeNode node3 = root.right;

        System.out.println("節點4與5距離: " + distanceBetweenNodes(root, node4, node5)); 

        System.out.println("樹的直徑: " + treeDiameter(root)); 

        List<TreeNode> dist2Nodes = nodesAtDistanceK(root, 2);
        System.out.print("距離根節點距離2的節點有: ");
        for (TreeNode n : dist2Nodes) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }
}