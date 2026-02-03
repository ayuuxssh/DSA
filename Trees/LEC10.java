package ayush.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Iterative Inorder Traversal using BFS
public class LEC10 extends TreeNode{
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer>ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true)
        {
            if(node!=null)
            {
                st.add(node);
                node = node.left;
            }
            else
            {
                if(st.empty())
                    break;
                node = st.peek();
                st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
