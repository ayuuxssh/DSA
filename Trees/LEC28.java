package ayush.BinaryTree;
//MAXIMUM WIDTH OF BINARY TREE
import java.util.*;
public class LEC28 extends TreeNode{
        static class Pair {
            TreeNode node;
            int first;

            Pair(TreeNode node, int first) {
                this.node = node;
                this.first = first;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {
            Queue<Pair> q = new LinkedList<>();
            int maxi = 0;
            q.add(new Pair(root, 0));
            while (!q.isEmpty()) {
                int size = q.size();
                int mini = q.peek().first;
                int first = 0;
                int last = 0;
                for (int i = 0; i < size; i++) {
                    int level = q.peek().first - mini;
                    TreeNode curr = q.peek().node;
                    q.remove();
                    if (i == 0)
                        first = level;
                    if (i == size - 1)
                        last = level;
                    if (curr.left != null) {
                        q.add(new Pair(curr.left, 2 * level + 1));
                    }
                    if (curr.right != null) {
                        q.add(new Pair(curr.right, 2 * level + 2));
                    }
                }
                maxi = Math.max(maxi, last - first + 1);
            }
            return maxi;
        }
    }