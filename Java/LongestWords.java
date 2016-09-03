/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import java.util.ArrayList;

/**
 *
 * @author eric
 */
public class LongestWords {
    
     public static void main(String[] args) {
        // TODO code application logic here
        
        String str1[] = {
            "dog",
            "google",
            "facebook",
            "internationalization",
            "blabla"
          };
        
        String str2[] = {
            "like",
            "love",
            "hate",
            "yes"
          };
         
        
        //System.out.println( "ans1: " + longestWords(str1));
        System.out.println( "ans2: " + longestWords(str2));
    }

    public static ArrayList<String> longestWords(String[] dictionary) {
     
        ArrayList<String> ans = new ArrayList<String>();
        
        int i = 0;
        int j = 1;
        int maxLen = 0;
        
        if(dictionary.length == 0 || dictionary.length == 1) return ans;
       
        // 1. Find the Longest Word index and length
        int maxIndex = 0;
        while( i < dictionary.length && j < dictionary.length)
        {
            String str1 = dictionary[i];
            String str2 = dictionary[j];
            
            int templen = 0;
            int tempIndex =0;
            
            if(str1.length() > str2.length())
            {
                templen = str1.length();
                tempIndex = i;
            }else {
                templen = str2.length();
                tempIndex = j;
            }
            
            if(templen >= maxLen)
            {
                maxIndex = tempIndex;
                maxLen = templen;
            }
            i++;
            j++;
        }
        ans.add(dictionary[maxIndex]);
        
        // 2. Find other Longest words
        for(i=0; i < dictionary.length ; i++)
        {
            if( maxIndex == i ) continue;
            if( maxLen == dictionary[i].length() ) ans.add(dictionary[i]);
        }
        
        return ans;
    }
    
}
