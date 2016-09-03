/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

/**
 *
 * @author eric
 */
public class LongLCS {
    
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int str1[] = { 5, 4, 2, 1, 3};
        int str2[] = { 5, 1, 2, 3, 4};
        
        System.out.println( "ans1: " + longestIncreasingContinuousSubsequence(str1));
        System.out.println( "ans2: " + longestIncreasingContinuousSubsequence(str2));
    }

    public static int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
      
        int len = 0;
        int count = 0;
        int i =0;
        int j =1;
        int currentFlg = 0;
        int previousFlg = 0;
        
        if(A.length == 0 ) return len;
          
        while( i < A.length && j < A.length )
        {
            if( A[i] - A[j] > 0 )
                currentFlg = 1;
            else 
                currentFlg = -1;
           
            if( i ==  0)
            {
                 count = 1;
                 
            }else {
                if( currentFlg == previousFlg )
                   count++;
                else 
                    count =1;
            }
            len = Math.max(len, count);
            
            previousFlg = currentFlg; 
            i++;
            j++;
           
        }
        return len+1;
    }
            
            
          
    
}
