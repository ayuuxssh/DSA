package ayush.BinaryTree;
//validate bst using ranges
public class LEC46 extends TreeNode{
        public boolean isValidBST(TreeNode root) {
            return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        private boolean valid(TreeNode root,long low,long high)
        {
            if(root == null)
            {
                return true;
            }
            if(root.val<=low || root.val>=high)
            {
                return false;
            }
            boolean left = valid(root.left,low,root.val);
            boolean right = valid(root.right,root.val,high);
            return left && right;
        }

}
