package ayush.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//RECOVER BINARY TREE
public class LEC52 extends TreeNode{
    //Brute Force
    //TC - O(N)+O(N)+O(NlogN)
    //SC-O(N)+Recursive stack space
        public void recoverTree(TreeNode root) {
            //Brute Force
            List<Integer> list = new ArrayList<>();
            inorder(root,list);
            Collections.sort(list);
            int[]idx={0};
            inorder1(root,list,idx);
        }
        private void inorder(TreeNode root, List<Integer>list)
        {
            if(root == null)
            {
                return;
            }
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
        private void inorder1(TreeNode root,List<Integer>list,int[]idx)
        {
            if(root==null)
            {
                return;
            }
            inorder1(root.left,list,idx);
            if(list.get(idx[0])!=root.val)
            {
                root.val = list.get(idx[0]);
            }
            idx[0]++;
            inorder1(root.right,list,idx);
        }
        private TreeNode first;
        private TreeNode last;
        private TreeNode middle;
        private TreeNode prev;

        public void recoverTree1(TreeNode root) {
            //Better appproach
            //TC-O(N)
            //SC-O(1)+RECURSIVE STACK SPACE
            first = middle = last = null;
            prev = new TreeNode(Integer.MIN_VALUE);
            inorder(root);
            if (first != null && last != null) {
                int curr = first.val;
                first.val = last.val;
                last.val = curr;
            } else {
                int curr = first.val;
                first.val = middle.val;
                middle.val = curr;
            }
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);

            if (prev != null && (root.val < prev.val)) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }
            prev = root;
            inorder(root.right);
        }

}
