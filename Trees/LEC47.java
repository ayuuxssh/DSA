package ayush.BinaryTree;
//LCA OF BST
public class LEC47 extends TreeNode{
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root!=null) {

                int curr = root.val;
                if (curr < p.val && curr < q.val) {
                    root = root.right;
                }
                else  if (curr > p.val && curr > q.val) {
                    root = root.left;
                }
                else
                {
                    return root;
                }
            }
            return null;
        }

}
