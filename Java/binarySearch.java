/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import static leetcodePractice.LeetCodeSample1.count;
import static leetcodePractice.TwoSum.twoSum;

/**
 *
 * @author eric
 */
public class binarySearch {
    
     public static void main(String[] args) {
        // TODO code application logic here
        
        int[] s = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
       
        //int[] s = {-1, 5, 1000, 3123, 1, 4, 46, 78, 6, 114};
         
        int target = 6;
       
        System.out.println("ans1: "+  binarySearchFind1(s, target));
    }
     
    
    //iteratively
    public static int binarySearchFind1(int[] num, int target)
    {
        if( num == null || num.length == 0) return -1;

        int start = 0;
        int end = num.length -1;
        while ( start < end )
        {
            int mid = ( start + end )  / 2;
            if(  num[mid] == target ) return mid;
            else if ( num[mid] > target ) end = mid -1;
            else if  ( num[mid] < target ) start = mid + 1;
          
        }

        return -1;
     }
    
     //recursively 
    public static int binarySearchFind2(int[] num, int target, int start, int end)
    {
        if( num == null || num.length == 0) return -1;

        while ( start < end )
        {
            int mid = ( start + end )  / 2;
            if(  num[mid] == target ) return mid;
            else if ( num[mid] > target ) binarySearchFind2(num, target, start, mid-1);
            else if  ( num[mid] < target ) binarySearchFind2(num, target, mid+1, end);
          
        }
        return -1;
        
     }
     
    
}
