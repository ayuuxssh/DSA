package ayush.SlidingWindow;

import java.util.HashMap;
//Count number of occurences of anagrams
public class LEC5 {

      public static  int search(String pat, String txt) {
            int k = pat.length();
            int n = txt.length();
            int count =0;
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int i=0;i<k;i++)
            {
                char it = pat.charAt(i);
                mp.put(it-'a',mp.getOrDefault(it-'a',0)+1);
            }
            int count1= mp.size();
            int i=0;int j=0;
            while(j<n)
            {
                if(mp.containsKey(txt.charAt(j)-'a'))
                {
                    mp.put(txt.charAt(j)-'a',mp.getOrDefault(txt.charAt(j)-'a',0)-1);
                    if(mp.get(txt.charAt(j)-'a')==0)
                    {
                        count1--;
                    }
                }

                if(j-i+1<k)
                {
                    j++;
                }
                else
                {
                    if(count1==0)
                    {
                        count++;
                    }
                    if(mp.containsKey(txt.charAt(i)-'a'))
                    {
                        if(mp.get(txt.charAt(i)-'a')==0)
                        {
                            count1++;
                        }
                        mp.put(txt.charAt(i)-'a',mp.getOrDefault(txt.charAt(i)-'a',0)+1);
                    }

                    i++;
                    j++;
                }
            }
            return count;

        }

    public static void main(String[] args) {

    }

    }

