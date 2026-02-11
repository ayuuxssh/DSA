package ayush.BinaryTree;
//ZigZagTraversal
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LEC19 extends TreeNode{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        if(root ==null)
            return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        boolean check = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer>list = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                list.add(0);
            }
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.peek();
                q.remove();
                int index = check?i:(size-1-i);
                list.set(index,curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            ans.add(list);
            check =!check;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
