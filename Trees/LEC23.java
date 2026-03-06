package ayush.BinaryTree;
import java.util.*;

//Bottom View of binary treee
public class LEC23  extends TreeNode{
        class Pair{
            TreeNode node;
            int first;
            Pair(TreeNode node , int first)
            {
                this.node = node;
                this.first = first;
            }
        }
        public ArrayList<Integer> bottomView(TreeNode root) {
            // code here
            Map<Integer,Integer>mp = new TreeMap<>();
            Queue<Pair>q = new LinkedList<>();
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
                else
                {
                    mp.remove(level);
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
            ArrayList<Integer>ans = new ArrayList<>();
            for(Map.Entry<Integer,Integer>it:mp.entrySet())
            {
                ans.add(it.getValue());
            }
            return ans;
        }
    }

