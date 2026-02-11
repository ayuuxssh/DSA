package ayush.BinaryTree;

import java.util.*;
//Vertical order traversal
public class LEC21 {
    class Tuple{
        TreeNode node;
        int first;
        int second;
        Tuple(TreeNode node,int first,int second)
        {
            this.node = node;
            this.first= first;
            this.second = second;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty())
        {
            TreeNode  curr = q.peek().node;
            int vertical = q.peek().first;
            int level = q.peek().second;
            q.remove();
            if(!mp.containsKey(vertical))
            {
                mp.put(vertical,new TreeMap<>());
            }
            if(!mp.get(vertical).containsKey(level))
            {
                mp.get(vertical).put(level,new PriorityQueue<>());
            }
            mp.get(vertical).get(level).add(curr.val);
            if(curr.left!=null)
            {
                q.add(new Tuple(curr.left,vertical-1,level+1));
            }
            if(curr.right!=null)
            {
                q.add(new Tuple(curr.right,vertical+1,level+1));
            }

        }
        List<List<Integer>>ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> it:mp.values())
        {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> y:it.values())
            {
                while(!y.isEmpty())
                {
                    ans.get(ans.size()-1).add(y.peek());
                    y.remove();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

