package ayush.SlidingWindow;
import java.util.*;
//Longest substring with k uniques
public class LEC10 {
        public static int longestKSubstr(String s, int k) {
            int n = s.length();
            HashMap<Character,Integer>mp= new HashMap<>();
            int i=0;
            int j=0;
            int ans =-1;
            int count =0;
            while(j<n)
            {

                mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)+1);
                if(mp.get(s.charAt(j))==1)
                {
                    count++;
                }
                if(count<k)
                {
                    j++;
                }
                else if(count==k)
                {
                    ans = Math.max(ans,j-i+1);
                    j++;
                }
                else
                {
                    while(count>k)
                    {
                        mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)-1);
                        if(mp.get(s.charAt(i))==0)
                        {
                            count--;
                        }
                        i++;
                    }

                    j++;
                }
            }
            return ans;
        }

    public static void main(String[] args) {

    }
    }

