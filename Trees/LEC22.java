package ayush.BinaryTree;

import java.util.*;
//Top view  of binary tree
public class LEC22 extends TreeNode{
        class Pair
        {
            TreeNode node;
            int first;
            Pair(TreeNode node,int first)
            {
                this.node = node;
                this.first= first;
            }
        }
        public ArrayList<Integer> topView(TreeNode root) {
            // code here
            Map<Integer,Integer> mp = new TreeMap<>();
            Queue<Pair> q= new LinkedList<>();
            q.add(new Pair(root,0));
            while(!q.isEmpty())
            {
                TreeNode curr = q.peek().node;
                int level = q.peek().first;
                q.remove();
                if(!mp.containsKey(level))
                {
                    mp.put(level,curr.val);
                }
                if(curr.left!=null)
                {
                    q.add(new Pair(curr.left,level-1));
                }
                if(curr.right!=null)
                {
                    q.add(new Pair(curr.right,level+1));
                }
            }
            ArrayList<Integer>list = new ArrayList<>();
            for(Map.Entry<Integer,Integer>it:mp.entrySet())
            {
                list.add(it.getValue());
            }
            return list;
        }
    }
