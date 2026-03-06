package ayush.BinaryTree;
import java.util.*;
//children sum property of binary tree
public class LEC29 extends TreeNode{
    //TC - O(N)
    //SC -O(N)
        public boolean isSumProperty(TreeNode root) {
            //  code here
            Queue<TreeNode>q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty())
            {
                int sum =0;
                TreeNode curr = q.peek();
                q.remove();
                if(curr.left==null && curr.right==null)
                    continue;

                if(curr.left!=null)
                {
                    sum+=curr.left.val;
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    sum+=curr.right.val;
                    q.add(curr.right);
                }

                if(curr.val != sum)
                {
                    return false;
                }
            }
            return true;
        }
        //RECURSIVE APPROACH
    //TC-O(N)
    //SC-O(H)
            public boolean isSumProperty1(TreeNode root) {
                //  code here

                if( root == null || (root.left==null && root.right==null))
                    return true;
                int sum =0;
                if(root.left!=null)
                {
                    sum+=root.left.val;
                }
                if(root.right!=null)
                {
                    sum+=root.right.val;
                }
                if(root.left!=null ||  root.right!=null)
                {
                    if(root.val!=sum)
                        return false;
                }
                return (isSumProperty1(root.left) && isSumProperty1(root.right));
            }
        }

