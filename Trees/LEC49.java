package ayush.BinaryTree;

import java.util.ArrayList;
//Inorder  predecessor and successor of bst
public class LEC49 extends TreeNode{
        public ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {
            // code here
            ArrayList<TreeNode>ans = new ArrayList<>();
            TreeNode succ =successor(root,key);
            TreeNode pred = predecessor(root,key);
            ans.add(pred);
            ans.add(succ);
            return ans;
        }
        private TreeNode successor(TreeNode root,int key)
        {
            TreeNode succ = null;
            while(root!=null)
            {
                if(root.val>key)
                {
                    succ = root;
                    root = root.left;
                }
                else
                {
                    root = root.right;
                }
            }
            return succ;
        }
        private TreeNode predecessor(TreeNode root,int key)
        {
            TreeNode pred = null;
            while(root!=null)
            {
                if(root.val<key)
                {
                    pred = root;
                    root = root.right;
                }
                else
                {
                    root = root.left;
                }
            }
            return pred;
        }

}
