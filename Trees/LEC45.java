package ayush.BinaryTree;

public class LEC45 extends TreeNode{
        private int count =0;
        private int result=0;
        public int kthSmallest(TreeNode root, int k) {
            helper(root,k);
            return result;
        }
        private void helper(TreeNode node , int k)
        {
            if(node == null || count>k)
                return ;
            helper(node.left,k);
            count++;
            if(count==k)
            {
                result = node.val;
            }
            helper(node.right,k);
        }

}
