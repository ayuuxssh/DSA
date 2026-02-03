package ayush.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//Iterative preorder traversal using 1 stack
public class LEC12 extends TreeNode{
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        List<Integer>list = new ArrayList<>();
        while(curr!=null || !st.empty())
        {
            if(curr!=null)
            {
                st.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode temp = st.peek().right;
                if(temp==null)
                {
                    TreeNode temp1 =st.peek();
                    st.pop();
                    list.add(temp1.val);
                    while(!st.empty() && temp1 == st.peek().right)
                    {
                        temp1 =st.peek();
                        st.pop();
                        list.add(temp1.val);                }
                }
                else
                {
                    curr =temp;
                }
            }
        }
        return list;
    }

}
