/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

/**
 * valid-anagram
 * ref: https://leetcode.com/course/chapters/leetcode-101/valid-anagram/
 * @author eric
 */
public class LeetCodeSample2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String s = "anagram";
        String t = "nagaram";
        
        if(isSubstring(s,t))
            System.out.println("YES");
        else
            System.out.println("NO");
   
    }

    // Best Solution
     public static boolean isSubstring(String s, String t)
     {
       if(s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
            
        }
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
        
     }

}
