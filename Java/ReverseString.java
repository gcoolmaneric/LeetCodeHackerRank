/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import java.util.ArrayList;
import static leetcodePractice.Strstr.Strstr;


/**
 *
 * @author eric
 */
public class ReverseString {
    
     public static void main(String[] args) {
        // TODO code application logic here
        
        String str1  = "hello, return olleh";
      
        System.out.println( "ReverseString ans: " + reverseStr(str1));  
        
    }
     
    public static String reverseStr(String source) {
      
        if(source.length() == 0 ) return "";
        
        ArrayList<String> ans = new ArrayList<String>();
         
        String temp = "";
        for(int i = 0; i < source.length(); i++  )
        {
           char ch = source.charAt(i);
           if( ch != ' ' && ch != '\n') {
               temp += ch;
           }
           else  {
               ans.add(temp + " ");
               temp = "";
           }
        }      
        ans.add(temp + " ");
         
        String resp = "";
        for(int j = ans.size()-1; j >= 0 ; j--  )
        {
            resp += ans.get(j);
        }
        return resp;
    }
    
}
