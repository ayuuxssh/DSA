package ayush.BinaryTree;
//BST ITERATOR
import java.util.Stack;

public class LEC50 extends TreeNode{
        Stack<TreeNode> st;

        public LEC50(TreeNode root) {
            st = new Stack<>();
            inorder(root, st);
        }

        private void inorder(TreeNode root, Stack<TreeNode> st) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode val = st.peek();
            st.pop();
            if (val.right != null) {
                inorder(val.right, st);
            }
            return val.val;
        }

        public boolean hasNext() {
            if (!st.empty())
                return true;
            return false;
        }
}
