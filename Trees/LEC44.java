package ayush.BinaryTree;
//Delete a node in bst
public class LEC44 extends TreeNode{
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null)
                return root;
            if(root.val == key)
            {
                return helper(root);
            }
            TreeNode dummy = root;
            while(root!=null)
            {
                if(root.val>key)
                {
                    if(root.left!=null && root.left.val ==key)
                    {
                        root.left = helper(root.left);
                        break;
                    }
                    else
                    {
                        root = root.left;
                    }
                }
                else
                {
                    if(root.right!=null && root.right.val == key)
                    {
                        root.right = helper(root.right);
                        break;
                    }
                    else
                    {
                        root = root.right;
                    }
                }
            }
            return dummy;
        }
        private TreeNode helper(TreeNode node)
        {
            if(node.left== null)
                return node.right;
            else if(node.right == null)
                return node.left;
            TreeNode prev = node.right;
            TreeNode curr = rightchild(node.left);
            curr.right = prev;
            return node.left;
        }
        private TreeNode rightchild(TreeNode node)
        {
            if(node.right == null)
                return node;
            return rightchild(node.right);

        }

}
