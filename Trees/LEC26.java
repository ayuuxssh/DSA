package ayush.BinaryTree;
import java.util.*;
//Print root to leaf path
public class LEC26 extends TreeNode {
        public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
            ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
            ArrayList<Integer>list = new ArrayList<>();
            path(root,ans,list);
            return ans;
        }
        private static void path(TreeNode node,ArrayList<ArrayList<Integer>>ans,ArrayList<Integer>result)
        {
            if(node == null)
                return;
            result.add(node.val);
            if(node.left == null &&  node.right ==null)
            {

                ans.add(new ArrayList<>(result));
                result.remove(result.size()-1);
                return;
            }
            else
            {
                path(node.left,ans,result);
                path(node.right,ans,result);
            }
            result.remove(result.size()-1);
        }
    }

