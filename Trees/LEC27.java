package ayush.BinaryTree;
//Lowest common ancestor of binary tree
public class LEC27 extends TreeNode{
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return lca(root,p,q);
        }
        private TreeNode lca(TreeNode node , TreeNode p , TreeNode q)
        {
            if(node==null || node ==p || node==q) {
                return node;
            }
            TreeNode left = lca(node.left,p,q);
            TreeNode right = lca(node.right,p,q);
            if(left==null )
            {
                return right;
            }
          else  if( right ==null)
            {
                return left;
            }
            else
            {
                return node;
            }
        }
    }
