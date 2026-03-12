package ayush.BinaryTree;
//Constructing Binary Tree from inorder and postorder
import java.util.*;
public class LEC35 extends TreeNode{
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            HashMap<Integer, Integer> mp = new HashMap<>();
            int n = inorder.length;
            for (int i = 0; i < n; i++) {
                mp.put(inorder[i], i);
            }
            return build(inorder, postorder, mp, 0, n - 1, 0, n - 1);
        }

        private TreeNode build(int[] inorder, int[] postorder, HashMap<Integer, Integer> mp, int instart, int inend, int poststart, int postend) {
            if (poststart > postend || instart > inend) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postend]);
            int inroot = mp.get(root.val);
            int num = inroot - instart;
            root.left = build(inorder, postorder, mp, instart, inroot - 1, poststart, poststart + num - 1);
            root.right = build(inorder, postorder, mp, inroot + 1, inend, poststart + num, postend - 1);
            return root;
        }
    }

