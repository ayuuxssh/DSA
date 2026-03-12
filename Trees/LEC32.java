package ayush.BinaryTree;
//Count Number of nodes in Complete binary tree in less than O(N)
public class LEC32 extends TreeNode{
        public int countNodes(TreeNode root) {
            return height1(root);
        }
        private int height1(TreeNode root)
        {
            if(root == null)
                return 0;
            int lh = leftheight(root);
            int rh = rightheight(root);
            if(lh!=rh)
            {
                return 1+height1(root.left)+height1(root.right);
            }
            return (2<<lh)-1;
        }
        private int leftheight(TreeNode node)
        {
            int count =0;
            while(node.left!=null)
            {
                count++;
                node = node.left;
            }
            return count;
        }
        private int rightheight(TreeNode node)
        {
            int count =0;
            while(node.right!=null)
            {
                count++;
                node = node.right;
            }
            return count;
        }
    }

