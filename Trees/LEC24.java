package ayush.BinaryTree;
import java.util.*;

//Right view of binary tree
public class LEC24 extends TreeNode {
        class Pair{
            TreeNode node;
            int first;
            Pair(TreeNode node,int first)
            {
                this.node = node;
                this.first=first;
            }
        }
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer>ans = new ArrayList<>();
            Map<Integer,Integer>mp = new TreeMap<>();
            if(root==null)
            {
                return ans;
            }
            Queue<Pair>q = new LinkedList<>();
            q.add(new Pair(root,0));
            while(!q.isEmpty())
            {
                TreeNode curr = q.peek().node;
                int level = q.peek().first;
                q.remove();
                mp.put(level,curr.val);
                if(curr.left!=null)
                {
                    q.add(new Pair(curr.left,level+1));
                }
                if(curr.right!=null)
                {
                    q.add(new Pair(curr.right,level+1));
                }
            }
            for(Map.Entry<Integer,Integer>it:mp.entrySet())
            {
                ans.add(it.getValue());
            }
            return ans;
        }
    }

