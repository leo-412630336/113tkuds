public class F11_BSTClosestValue {
    
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

    public static int closestValue(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException("Root cannot be null");

        int closest = root.val;
        TreeNode current = root;
        
        while (current != null) {
            double currDist = Math.abs(current.val - target);
            double closestDist = Math.abs(closest - target);

            if (currDist < closestDist) {
                closest = current.val;
            } else if (currDist == closestDist) {
                closest = Math.min(closest, current.val);
            }
            
            if (target < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        return closest;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        double target1 = 3.714286;
        System.out.println("Closest to " + target1 + ": " + closestValue(root1, target1)); // 4

        TreeNode root2 = new TreeNode(1);
        double target2 = 4.428571;
        System.out.println("Closest to " + target2 + ": " + closestValue(root2, target2)); // 1

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(7);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(4);
        root3.right.left = new TreeNode(6);
        double target3 = 4.5;
        System.out.println("Closest to " + target3 + ": " + closestValue(root3, target3)); // 4
    }
}