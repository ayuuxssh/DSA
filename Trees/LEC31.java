package ayush.BinaryTree;
import java.util.*;
//Minimum time to burn the entire binary tree
public class LEC31 extends TreeNode{
        class Pair{
            TreeNode node;
            int time;
            Pair(TreeNode node,int time)
            {
                this.node = node;
                this.time = time;
            }
        }
        public int minTime(TreeNode root, int target) {
            int ans =0;
            HashMap<TreeNode,TreeNode>mp = new HashMap<>();
            parent(root,mp);
            TreeNode curr = dest(root,target);
            Queue<Pair>q = new LinkedList<>();
            HashMap<TreeNode,Integer>vis = new HashMap<>();
            q.add(new Pair(curr,0));
            vis.put(curr,curr.val);
            while(!q.isEmpty())
            {
                TreeNode pre = q.peek().node;
                int time = q.peek().time;
                ans = time;
                q.remove();
                if(pre.left!=null)
                {
                    if(!vis.containsKey(pre.left))
                    {
                        q.add(new Pair(pre.left,time+1));
                        vis.put(pre.left,pre.left.val);
                    }
                }
                if(pre.right!=null)
                {
                    if(!vis.containsKey(pre.right))
                    {
                        q.add(new Pair(pre.right,time+1));
                        vis.put(pre.right,pre.right.val);
                    }
                }
                TreeNode parent = mp.get(pre);
                if(parent!=null)
                {
                    if(!vis.containsKey(parent))
                    {
                        q.add(new Pair(parent,time+1));
                        vis.put(parent,parent.val);
                    }
                }
            }
            return ans;
        }
        private TreeNode dest(TreeNode node, int target)
        {
            if(node == null || node.val == target)
                return node;

            TreeNode left =  dest(node.left,target);
            if(left!=null)
                return left;
            return dest(node.right,target);
        }
        private void parent(TreeNode node, HashMap<TreeNode,TreeNode>mp)
        {
            Queue<TreeNode>q= new LinkedList<>();
            q.add(node);
            while(!q.isEmpty())
            {
               TreeNode curr = q.peek();
                q.remove();
                if(curr.left!=null)
                {
                    q.add(curr.left);
                    mp.put(curr.left,curr);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                    mp.put(curr.right,curr);
                }
            }
        }
    }
