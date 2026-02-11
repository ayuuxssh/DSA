package ayush.BinaryTree;

//Boundary order traversal
import java.util.ArrayList;
import java.util.List;

public class LEC20 extends TreeNode {
    void LeftBoundary(ArrayList<Integer> ans, TreeNode root) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (isLeaf(curr) == false) {
                ans.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    void Leaf(ArrayList<Integer> ans, TreeNode root) {
        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }
        if (root.left != null) {
            Leaf(ans, root.left);
        }
        if (root.right != null) {
            Leaf(ans, root.right);
        }
    }

    void RightBoundary(ArrayList<Integer> ans, TreeNode root) {
        TreeNode curr = root.right;
        List<Integer> list = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                list.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else
                curr = curr.left;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }
    }

    boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    ArrayList<Integer> boundaryTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (!isLeaf(root)) {
            ans.add(root.val);
        }
        LeftBoundary(ans, root);
        Leaf(ans, root);
        RightBoundary(ans, root);
        return ans;
    }

    public static void main(String[] args) {

    }
}
