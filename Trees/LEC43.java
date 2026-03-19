package ayush.BinaryTree;
//Insert a node in bst
public class LEC43 extends TreeNode{
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null)
            {
                return new TreeNode(val);
            }
            else
            {
                return BST(root, val);
            }
        }

        private TreeNode BST(TreeNode root, int val) {
            if (root == null)
                return null;
            if (root.val > val) {
                TreeNode left = BST(root.left, val);
                if (left == null) {
                    root.left = new TreeNode(val);
                    return root;
                }
            } else {
                TreeNode right = BST(root.right, val);
                if (right == null) {
                    root.right = new TreeNode(val);
                    return root;
                }
            }
            return root;
        }
}
