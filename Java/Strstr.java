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
public class Strstr {
    
      public static void main(String[] args) {
        // TODO code application logic here
        
        String str1  = "source";
        String str2  = "abcdabcdefg";
        String str4  = "tartarget";
      
        
        //System.out.println( "ans1: " + findStrPos(str1, "target"));
        //System.out.println( "ans2: " + findStrPos(str2, "bcd"));
        //System.out.println( "ans3: " + findStrPos(str2, "def")); 
        System.out.println( "ans4: " + Strstr(str4, "target"));          
    }
   
    /*
    public static int findStrPos(String source, String target) {
        //write your code hetarre
        if(source == null || target == null || source.length() < target.length()) 
            return -1;
        
        //["abc", ""] return 0?    
        if(target.length() == 0)
            return 0;
            
        int j =0;
        int firstIndex = 0;
        boolean change = false;
        
        for(int i = 0; i < source.length() ; i++)
        {
            if( j < target.length() && target.charAt(j) == source.charAt(i)) 
            {
                j++;
                if( j == 1 || change) firstIndex = i;
                if(j == target.length()) 
                    return firstIndex;
            }else {
                j = 1;
                change = true;
            }
        }
            
       
        return -1;
    }
      */
      
    
   public static int Strstr(String source, String target) {
        //write your code hetarre
         if(source == null || target == null ) 
            return -1;

        for(int i = 0; i < source.length() ; i++)
        {
           int j = 0;
           for(j = 0; j < target.length(); j++)
           {
               if( source.charAt(i+j) != target.charAt(j)) break;
           }
           if( j == target.length()) 
               return i;
        }
            
        return -1;
    }
   
   
    public static int findStrPos(String source, String target) {
        //write your code hetarre
         if(source == null || target == null || source.length() < target.length()) 
            return -1;
        
        //["abc", ""] return 0?    
        if(target.length() == 0)
            return 0;
            
        int j =0;
        for(int i = 0; i < source.length() ; i++)
        {
           if(source.charAt(i) == target.charAt(j) && j == target.length() -1)
                return i - j;
                
            if(source.charAt(i) == target.charAt(j))
                j++;
            else 
                j=0;
        }
            
        return -1;
    }
      
}
