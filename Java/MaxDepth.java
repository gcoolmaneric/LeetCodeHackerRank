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
public class MaxDepth {
   
     public static void main(String[] args) {
        // TODO code application logic here
     }
     
     public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
    }
    
     public int maxDepth(TreeNode root) 
     {
         if(root == null) return 0;
         
         int left  = maxDepth(root.left);
         int right = maxDepth(root.right);
         
         return left > right ? left+1 : right +1;
     }
    
}
