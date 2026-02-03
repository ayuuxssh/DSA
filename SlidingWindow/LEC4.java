package ayush.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Find the first negative of window of size k
public class LEC4 {
        public static List<Integer> firstNegInt(int arr[], int k) {
            List<Integer>list = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            int n = arr.length;
            int i=0;int j=0;
            while(j<n)
            {
                if(j-i+1<k)
                {
                    if(arr[j]<0)
                    {
                        q.add(arr[j]);
                    }
                    j++;
                }
                else
                {
                    if(arr[j]<0)
                    {
                        q.add(arr[j]);
                    }
                    if(!q.isEmpty())
                    {
                        list.add(q.peek());
                    }
                    else
                    {
                        list.add(0);
                    }
                    if(arr[i]<0)
                    {
                        q.remove();
                    }
                    i++;
                    j++;
                }
            }
            return list;

        }

    public static void main(String[] args) {

    }
    }

