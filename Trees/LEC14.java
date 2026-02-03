package ayush.BinaryTree;
//Diameeter of Binary Tree
public class LEC14 extends TreeNode{
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    int height(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        int dia = left+right;
        diameter = Math.max(dia,diameter);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {

    }
}


