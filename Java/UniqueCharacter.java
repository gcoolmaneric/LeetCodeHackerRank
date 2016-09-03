/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author eric
 */
public class UniqueCharacter {
    
       public static void main(String[] args) {
        // TODO code application logic here
        
        String str1  = "abc";
        String str2  = "aab";
        String str3  = "abc_______";
        String str4  = "0a123a45a6";
        
        //System.out.println( "ans1: " + Integer.MAX_VALUE);
        //System.out.println( "ans1: " + getUniqueArray(str4));
        
        System.out.println( "isUniqueWithoutMap : " + isUniqueWithoutMap(str4));
        
    }


    public static boolean isUniqueWithoutMap(String str) {
        
        if(str.length() == 0 || str.length() == 1) return true;
        
        int symbol[] = new int[1024];
        
        // Reset symbol table 
        for(int i=0; i < str.length() ; i ++ )
            symbol[i] = 0;
        
        // Update character 
        for(int i=0; i < str.length() ; i ++ )
        {
            char chk = str.charAt(i);
            symbol[ chk - 'a'] += 1;
            
             if(symbol[chk - 'a'] > 1 )
                return false;
        }
        
        return true;
    }
       
    public static boolean isUnique(String str) {
        
        if(str.length() == 0 || str.length() == 1) return true;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        // Update character 
        for(int i=0; i < str.length() ; i ++ )
        {
            char chk = str.charAt(i);
            if(map.containsKey(chk))
            {
                map.put(chk, map.get(chk) + 1 );
                return false;
            }else {
                map.put(chk, 1);
            }
  
        }
        
        return true;
    }
    
    
    public static Vector<String> getUniqueArray(String str) {
        
        if(str.length() == 0 || str.length() == 1) return null;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Vector<String> ans = new Vector<String>();
        
        // Update character 
        int len = 0;
        int maxLen = 0;
        for(int i=0; i < str.length() ; i ++ )
        {
            char chk = str.charAt(i);
            if(map.containsKey(chk))
            {
                map.put(chk, map.get(chk) + 1 );
                len = 0;
            }else {
                map.put(chk, 1);
                len++;
            }
            if(len > maxLen )
            {
                maxLen = len;
                ans.add(Character.toString(chk));
            }
        }
        
        return ans;
    }
    
    
    
}
