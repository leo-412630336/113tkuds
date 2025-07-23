public class TreeMirror {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 判斷一棵樹是否是對稱的（左右互為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 判斷兩棵子樹是否互為鏡像
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.data == t2.data)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // 將一棵樹轉成它的鏡像（原地交換）
    public static void mirror(TreeNode root) {
        if (root == null) return;

        // swap 左右節點
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    // 中序印出樹結構
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // 建立一棵對稱的樹
        TreeNode symmetricTree = new TreeNode(1);
        symmetricTree.left = new TreeNode(2);
        symmetricTree.right = new TreeNode(2);
        symmetricTree.left.left = new TreeNode(3);
        symmetricTree.left.right = new TreeNode(4);
        symmetricTree.right.left = new TreeNode(4);
        symmetricTree.right.right = new TreeNode(3);

        // 建立一棵不對稱的樹
        TreeNode asymmetricTree = new TreeNode(1);
        asymmetricTree.left = new TreeNode(2);
        asymmetricTree.right = new TreeNode(2);
        asymmetricTree.left.right = new TreeNode(3);
        asymmetricTree.right.right = new TreeNode(3);

        // 測試是否對稱
        System.out.println("symmetricTree 是否對稱: " + isSymmetric(symmetricTree)); // true
        System.out.println("asymmetricTree 是否對稱: " + isSymmetric(asymmetricTree)); // false

        // 測試鏡像轉換
        System.out.println("\n原始 symmetricTree 中序:");
        printInOrder(symmetricTree);
        mirror(symmetricTree);
        System.out.println("\n鏡像後 symmetricTree 中序:");
        printInOrder(symmetricTree);

        // 測試兩棵樹是否互為鏡像
        TreeNode treeA = new TreeNode(1);
        treeA.left = new TreeNode(2);
        treeA.right = new TreeNode(3);

        TreeNode treeB = new TreeNode(1);
        treeB.left = new TreeNode(3);
        treeB.right = new TreeNode(2);

        System.out.println("\n\n兩棵樹 treeA 與 treeB 是否互為鏡像: " + isMirror(treeA, treeB)); // true
    }
}