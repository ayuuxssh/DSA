package ayush.BinaryTree;
//Iterative Traversal using stack in preorder
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LEC9 {


        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> st = new Stack<>();
            List<Integer>ans = new ArrayList<>();
            if(root!=null)
            {
                st.add(root);
            }
            while(!st.empty())
            {
                TreeNode curr = st.peek();
                st.pop();
                ans.add(curr.val);
                if(curr.right!=null)
                {
                    st.add(curr.right);
                }
                if(curr.left!=null)
                {
                    st.add(curr.left);
                }
            }
            return ans;
        }

    public static void main(String[] args) {

    }
}
