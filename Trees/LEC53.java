package ayush.BinaryTree;
//LARGEST BST
public class LEC53 extends TreeNode{
        static class NodeValue{
            int maxi;
            int mini;
            int size;
            NodeValue(int maxi,int mini,int size)
            {
                this.maxi =maxi;
                this.mini = mini;
                this.size = size;
            }
        }
        // Return the size of the largest sub-tree which is also a BST
        static NodeValue largest( TreeNode root) {
            // Write your code here
            //when there is no node
            if(root == null)
            {
                return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
            }
            //Get values from left and right subtreee of current tree
            NodeValue left = largest(root.left);
            NodeValue right = largest(root.right);
            if(left.maxi<root.val && root.val<right.mini)
            {
                return new NodeValue(Math.max(root.val,right.maxi),Math.min(root.val,left.mini),left.size+1+right.size);
            }
            else
            {
                return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.size,right.size));
            }

        }
        static int largestBst(TreeNode root)
        {
            return largest(root).size;
        }

}
