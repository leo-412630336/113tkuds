import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversePaths(root, new ArrayList<>(), result);
        return result;
    }

    private static void traversePaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            traversePaths(node.left, path, result);
            traversePaths(node.right, path, result);
        }

        path.remove(path.size() - 1); // 回溯
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null)
            return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        findMaxPath(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void findMaxPath(TreeNode node, List<Integer> path, int currentSum, int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        path.add(node.val);
        currentSum += node.val;

        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(path);
            }
        } else {
            findMaxPath(node.left, path, currentSum, maxSum, maxPath);
            findMaxPath(node.right, path, currentSum, maxSum, maxPath);
        }

        path.remove(path.size() - 1); // 回溯
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("所有根到葉的路徑：");
        List<List<Integer>> paths = allPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        int target = 22;
        System.out.println("\n是否存在總和為 " + target + " 的路徑？ " + hasPathSum(root, target));

        List<Integer> maxPath = maxPathSum(root);
        System.out.println("\n和最大的根到葉路徑：" + maxPath);
    }
}