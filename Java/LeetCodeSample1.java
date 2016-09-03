/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

/**
 * remove-duplicates-from-sorted-array
 * ref: https://leetcode.com/course/chapters/leetcode-101/remove-duplicates-from-sorted-array/
 * @author eric
 */
public class LeetCodeSample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        char str1[] = {1,1,2};
        char str2[] = {1,1,1,1,2,2,2,3,3};
        char str3[] = {2,2,1,1,1, 2,2,2,3,3};
         
        System.out.println("ans1: "+ count(str1));
        System.out.println("ans2: "+ count(str2));
        System.out.println("ans3: "+ count(str3));
    }

     // My Solution
    /*
     public static int count(char []str)
     {
        int maxLen =0;
        int tmpCount = 0;
        char tmpA = '\0';
        
        for(int i=0; i < str.length; i++)
        {
            if(tmpA == '\0' )
            {
                tmpA = str[i];
                tmpCount = 1;
                
            }else if(tmpA != '\0' && tmpA == str[i] )
            {
                tmpA = str[i];
                tmpCount++;
             
            }else if(tmpA != '\0' && tmpA != str[i] )
            {
                 maxLen = Math.max(tmpCount, maxLen);
                 tmpA = str[i];
                 tmpCount = 1;
            }
    
             
        }
      
         return maxLen;
            
     }
    */
     
    
    
    /*
     public static int count(char []str)
     {
        int maxLen =0;
        int i =0;
        for(int j=0; j < str.length; j++)
        {
           if(str[j] != str[i])
           {
               maxLen++;
               str[i] = str[j];
           }
             
        }
         return maxLen;
     }
     */
    
     public static int count(char []str)
     {
        int maxLen =0;
        int i =0;
        int tmpLen =0;
        for(int j=0; j < str.length; j++)
        {
           if(str[j] == str[i])
           {
               tmpLen++;
               maxLen = Math.max(tmpLen, maxLen);
               
           }else {
               tmpLen = 1;
               str[i] = str[j];
           }
             
        }
      
         return maxLen;
            
     }

}
