/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import static leetcodePractice.UniqueCharacter.isUnique;

/**
 *
 * @author eric
 */
public class BinaryTreePath {
 
     public static void main(String[] args) {
        // TODO code application logic here
        int $t1=0 ;
        
        String str1  = "abc";
        String str2  = "aab";
        String str3  = "abc_______";
        
        System.out.println( "ans1: " + isUnique(str1));
        System.out.println( "ans2: " + isUnique(str2));
        System.out.println( "ans3: " + isUnique(str3));
    }
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null) 
            return 0;
        
        return getMin(root);
    }
    
    public int getMin(TreeNode root)
    {
        if(root == null )
            return 0;
         
        if ( root.left == null && root.right == null)
            return 1;
     
        return Math.max(getMin(root.left), getMin(root.right) + 1);
    }
}
