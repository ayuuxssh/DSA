package ayush.BinaryTree;
import java.util.*;
//All nodes at the distance of k
public class LEC30 extends TreeNode{
        class Pair{
            TreeNode node ;
            int first;
            Pair(TreeNode node , int first)
            {
                this.node = node;
                this.first = first;
            }
        }
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            HashMap<TreeNode, TreeNode> mp = new HashMap<>();
            parent(root, mp);
            HashMap<TreeNode, Integer> mp1 = new HashMap<>();
            Queue<Pair> q = new LinkedList<>();

            q.add(new Pair(target,0));
            mp1.put(target, target.val);
            while (!q.isEmpty()) {
                TreeNode curr = q.peek().node;
                q.remove();
                int dist = q.peek().first;
                if (dist == k)
                    break;

                    if (curr.left != null) {
                        if (!mp1.containsKey(curr.left)) {
                            q.add(new Pair(curr.left,dist+1));
                            mp1.put(curr.left, curr.left.val);
                        }
                    }
                    if (curr.right != null) {
                        if (!mp1.containsKey(curr.right)) {
                            q.add(new Pair(curr.right,dist+1));
                            mp1.put(curr.right, curr.right.val);
                        }
                    }
                    TreeNode parent = mp.get(curr);
                    if (parent != null) {
                        if (!mp1.containsKey(parent)) {
                            q.add(new Pair(parent, dist + 1));
                            mp1.put(parent, parent.val);
                        }
                    }
            }
            List<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode curr = q.peek().node;
                q.remove();
                ans.add(curr.val);
            }
            return ans;
        }

        private void parent(TreeNode node, HashMap<TreeNode, TreeNode> mp) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(node);
            while (!q.isEmpty()) {
                TreeNode curr = q.peek();
                q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                    mp.put(curr.left, curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    mp.put(curr.right, curr);
                }
            }
        }
    }
