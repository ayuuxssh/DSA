package ayush.BinaryTree;

//Check if tree is height balanced or not
public class LEC13 extends TreeNode{
    //O(N^2)
        public boolean isBalanced(TreeNode root) {
            if(root ==null)
                return true;
            int left = height(root.left);
            int right = height (root.right);
            if(Math.abs(left-right)>1)
                return false;
            boolean leftcheck = isBalanced(root.left);
            boolean rightcheck = isBalanced(root.right);
            if(!leftcheck || !rightcheck)
            {
                return false;
            }
            return true;
        }
        private int height(TreeNode node)
        {
            if(node == null)
            {
                return 0;
            }
            int left = height(node.left);
            int right = height(node.right);
            return Math.max(left,right)+1;
        }

    }
    //O(N)
//public boolean isBalanced(TreeNode root) {
//    if(root ==null)
//        return true;
//    if(height(root)==-1)
//        return false;
//    return true;
//}
//private int height(TreeNode node)
//{
//    if(node == null)
//    {
//        return 0;
//    }
//    int left = height(node.left);
//    int right = height(node.right);
//    if(left==-1 ||right==-1)
//        return -1;
//    if(Math.abs(left-right)>1)
//        return -1;
//    return Math.max(left,right)+1;
//}

