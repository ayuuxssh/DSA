package ayush.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
//Sliding Window maximum
public class LEC6 {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer>ans = new ArrayList<>();
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int i =0;
        int j=0;
        while(j<n)
        {
            while(!dq.isEmpty() && dq.peekLast()<arr[j])
            {
                dq.removeLast();
            }
            dq.addLast(arr[j]);
            if(j-i+1<k)
            {
                j++;
            }
            else
            {
                ans.add(dq.peekFirst());
                if(dq.peekFirst()==arr[i])
                {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
