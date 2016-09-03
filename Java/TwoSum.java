/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import java.util.HashMap;

/**
 * valid-anagram
 * ref: https://leetcode.com/course/chapters/leetcode-101/valid-anagram/
 * @author eric
 */
public class TwoSum {

    /**
     * Two Sum
     * ref: https://leetcode.com/course/chapters/leetcode-101/two-sum/
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] s = { 3, 7, 8, 10};
        int target = 11;
       
        twoSum(s, target);
        
    }


     // Best Solution
     public static int[] twoSum(int[] s, int target)
     {
       if(s.length == 0 ) return null;
       int [] ans = new int[2];
       
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

       for(int i=0; i < s.length; i++)
       {
           if(!map.containsKey(s[i]))
           {
               map.put(target-s[i], s[i]);
            
           }else {
               ans[0] = s[i];
               ans[1] =  target-s[i];
           }
           
      
       }
   
       for(int i=0; i < ans.length; i++)
       {
           System.out.println(" ans: "+ ans[i]);
       }
       return ans;
       
     }

    
    
    /*
    // No HashMap
     public static int[] twoSum(int[] s, int target)
     {
       if(s.length == 0 ) return null;
       int [] ans = new int[2];
       int [] symbol = new int[1000];
       
       for(int i=1; i < s.length; i++) 
           symbol[s[i] - '0'] = -1;
     
       for(int i=0; i < s.length; i++)
       {
           if(symbol[s[i] - '0'] != -1)
           {
               symbol[target - s[i] - '0'] = s[i];
              
           }else {
               if( s[i] == symbol[target - s[i] - '0'])
               {
                    ans[0] = target - s[i];
                    ans[1] = s[i];
               }
           }
      
       }
   
       return ans;
     }
     */
    
     
}
