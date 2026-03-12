package ayush.BinaryTree;
//Serialiaze and Deserialize of binary tree
import java.util.LinkedList;
import java.util.Queue;

public class LEC36 extends TreeNode{
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)
                return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            q.add(root);
            while(!q.isEmpty())
            {
                TreeNode curr = q.peek();
                q.remove();
                if(curr==null)
                {
                    sb.append("n"+" ");
                    continue;
                }
                else
                {
                    sb.append(curr.val+" ");
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            System.out.println(sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<TreeNode>q = new LinkedList<>();
            if(data == "")
                return null;
            String []values = data.split(" ");
            int n = values.length;
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for(int i=1;i<n;i++)
            {
                TreeNode curr = q.poll();
                if(!values[i].equals("n"))
                {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    curr.left = left;
                    q.add(left);
                }
                if(!values[++i].equals("n"))
                {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    curr.right = right;
                    q.add(right);
                }

            }
            return root;
        }
    }
