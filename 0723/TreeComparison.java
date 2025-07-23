public class TreeComparison {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    static class Result {
        TreeNode node;
        int size;

        Result(TreeNode node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    public static TreeNode largestCommonSubtree(TreeNode t1, TreeNode t2) {
        return findLargestCommon(t1, t2).node;
    }

    private static Result findLargestCommon(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return new Result(null, 0);

        if (isSameTree(t1, t2)) {
            int size = countNodes(t1);
            return new Result(t1, size);
        }

        Result left = findLargestCommon(t1.left, t2.left);
        Result right = findLargestCommon(t1.right, t2.right);

        return left.size >= right.size ? left : right;
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        t3.left = new TreeNode(1);
        t3.right = new TreeNode(3);

        System.out.println("兩棵樹是否完全相同 (t1, t1)： " + isSameTree(t1, t1)); 
        System.out.println("t2 是否為 t1 的子樹： " + isSubtree(t1, t2)); 
        System.out.println("t3 是否為 t1 的子樹： " + isSubtree(t1, t3)); 

        TreeNode common = largestCommonSubtree(t1, t2);
        System.out.print("最大公共子樹的中序遍歷：");
        printInOrder(common); 
        System.out.println();
    }
}