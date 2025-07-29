import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vals.add(sc.nextInt());
        }

        TreeNode root = buildTree(vals);

        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);
        System.out.println(sum);
    }

    public static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < vals.size()) {
            TreeNode curr = queue.poll();
            if (i < vals.size() && vals.get(i) != -1) {
                curr.left = new TreeNode(vals.get(i));
                queue.offer(curr.left);
            }
            i++;
            if (i < vals.size() && vals.get(i) != -1) {
                curr.right = new TreeNode(vals.get(i));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;

        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }
}