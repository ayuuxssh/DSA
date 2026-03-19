package ayush.BinaryTree;
//Search in binary search tree
public class LEC40 extends TreeNode{
        public TreeNode searchBST(TreeNode root, int val) {
            while(root!=null && root.val!=val)
            {
                root = (root.val>val)?root.left:root.right;
            }
            return root;
        }
    }

