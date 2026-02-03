package ayush.SlidingWindow;

import java.util.HashMap;

//Longest substring without repeating character
public class LEC11 {
        public int longestUniqueSubstr(String s) {
            int n = s.length();
            HashMap<Character,Integer> mp= new HashMap<>();
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

                if(count==j-i+1)
                {
                    ans = Math.max(ans,j-i+1);
                    j++;
                }
                else
                {
                    while(count<j-i+1)
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
