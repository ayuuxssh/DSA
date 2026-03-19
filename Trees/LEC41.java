package ayush.BinaryTree;

//ceil of bst
public class LEC41 extends TreeNode{
        int findCeil(TreeNode root, int x) {
            // code here
            if(root == null)
                return -1;
            if(root.val <x)
            {
                return findCeil(root.right,x);
            }
            int left = findCeil(root.left,x);
            if(left!=-1)
                return left;
            return root.val;
        }

        //floor of bst
        public static int floor(TreeNode root, int x) {
        if(root == null)
            return -1;
        if(root.val==x)
        {
            return root.val;
        }
        else if(root.val>x)
        {
            return floor(root.left,x);
        }
        int right = floor(root.right,x);
        if(right!=-1)
            return right;
        return root.val;
    }
}


