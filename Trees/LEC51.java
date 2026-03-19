package ayush.BinaryTree;
//Two sum input is BST
import java.util.Stack;

public class LEC51 extends TreeNode{
        public boolean findTarget(TreeNode root, int k) {
            Stack<TreeNode> st = new Stack<>();
            Stack<TreeNode> st1 = new Stack<>();
            inorder(root, st);
            inorder1(root, st1);

            int x = next(st);
            int y = before(st1);
            while (x < y) {
                if (x + y < k) {
                    x = next(st);
                } else if (x + y > k) {
                    y = before(st1);
                } else {
                    return true;
                }
            }
            return false;
        }

        private int next(Stack<TreeNode> st) {
            TreeNode curr = st.peek();
            st.pop();
            inorder(curr.right, st);
            return curr.val;
        }

        private int before(Stack<TreeNode>st)
        {
            TreeNode curr = st.peek();
            st.pop();
            inorder1(curr.left,st);
            return curr.val;
        }

        private void inorder(TreeNode root, Stack<TreeNode> st) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }

        private void inorder1(TreeNode root, Stack<TreeNode> st) {
            while (root != null) {
                st.push(root);
                root = root.right;
            }
        }

}
