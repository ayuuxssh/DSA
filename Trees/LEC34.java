package ayush.BinaryTree;
import java.util.*;
//constructing binary tree from inorder and preorder
public class LEC34 extends TreeNode{
        public TreeNode buildTree(int[] inorder, int[] preorder) {
            HashMap<Integer,Integer>mp = new HashMap<>();
            int n = inorder.length;
            for(int i=0;i<n;i++)
            {
                mp.put(inorder[i],i);
            }
            return build(inorder,preorder,mp,0,n-1,0,n-1);
        }
        private TreeNode build(int[]inorder,int[]preorder,HashMap<Integer,Integer>mp,int instart,int inend,int prestart,int preend)
        {
            if(prestart>preend || instart>inend)
            {
                return null;
            }
            TreeNode root = new TreeNode(preorder[prestart]);
            int inroot = mp.get(root.val);
            int num= inroot-instart;
            root.left = build(inorder,preorder,mp,instart,inroot-1,prestart+1,prestart+num);
            root.right = build(inorder,preorder,mp,inroot+1,inend,prestart+num+1,preend);
            return root;
        }
    }

