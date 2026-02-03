package ayush.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//Iterative postorder using 2 stacks
//push the root
//While poping out push into second stack and push the left and right children in stack 1

public class LEC11 extends TreeNode {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer>st1 = new Stack<>();
        List<Integer>list = new ArrayList<>();
        if(root!=null)
        {
            st.add(root);
        }
        while(!st.empty())
        {
            TreeNode curr = st.peek();
            st.pop();
            st1.add(curr.val);
            if(curr.left!=null)
            {
                st.add(curr.left);
            }
            if(curr.right!=null)
            {
                st.add(curr.right);
            }
        }
        for( int it:st1)
        {
            list.add(it);
        }
        Collections.reverse(list);
        return list;
    }

}
