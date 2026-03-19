package ayush.BinaryTree;
//Construct bst from preorder
public class LEC48 extends TreeNode{
        public TreeNode bstFromPreorder(int[] preorder) {
            return build(preorder,Integer.MAX_VALUE,new int[]{0});
        }
        private TreeNode build(int []preorder,int high,int []i)
        {
            if(i[0]==preorder.length || preorder[i[0]]>high)
            {
                return null;
            }
            TreeNode root = new TreeNode(preorder[i[0]++]);
            root.left = build(preorder,root.val,i);
            root.right = build(preorder,high,i);
            return root;
        }

}
