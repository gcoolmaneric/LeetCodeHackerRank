/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import java.util.Stack;
import java.util.HashMap;


/**
 *
 * @author eric
 */
public class ValidParentheses {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        String test = "([)]";   
        System.out.println(" ValidParentheses str: "+ test + " ans: " + vaildCheck(test));
        
        String test2 = "()[]{}";
        System.out.println(" ValidParentheses str: "+ test2 + " ans: " + vaildCheck(test2));
        
        String test3 = "((";
        System.out.println(" ValidParentheses str: "+ test3 + " ans: " + vaildCheck(test3));
        
        String test4 = "([";
        System.out.println(" ValidParentheses str: "+ test4 + " ans: " + vaildCheck(test4));
    }
    
    public static boolean vaildCheck(String input)
    {
        if(input.length() == 1 || input == null ) return false;
        
        HashMap<String, String> _map = new HashMap<String, String>();        
        _map.put("(", ")");
        _map.put("{", "}");
        _map.put("[", "]");
        
              
        String lastKeyStr = ""; 
        String lastValueStr = "";
        char []newInput = input.toCharArray();
        for( char data: newInput)
        {
            if(_map.containsKey(Character.toString(data)) ){               
                if(lastKeyStr.equals(Character.toString(data)) ) 
                    return false;
                lastValueStr = _map.get(Character.toString(data));
                lastKeyStr = Character.toString(data);

            }else {
               if( !lastValueStr.equals(Character.toString(data)))
                   return false;
            }     
        }
        return true;
    }

    // Bug
    /*
    public static boolean vaildCheck(String input)
    {
        if(input.length() == 1 ) return false;
          
        String left  = "({[";
        String right = ")}]";
        Stack stk = new Stack();
         
        char []newInput = input.toCharArray();
        
        for( char data: newInput)
        {
            if(left.contains(Character.toString(data))){
                stk.push(data);
            }else {
                int tmp = right.indexOf(Character.toString(data));
                if( stk.empty() && stk.get(tmp) == null)
                    return false;
                else 
                    if(!stk.empty()) stk.pop();
            }     
        }
        return stk.empty();
    }
    */
    
    
     /*
    public static boolean vaildCheck(String s)
    {        
        int index1Count = 0, index2Count =0, index3Count = 0;
        
        char []newInput = s.toCharArray();
        
        for( char data: newInput)
        {
            if( data == '(') index1Count++;
            else if( data == ')') index1Count--;
            
            if( data == '{') index2Count++;
            else if( data == '}') index2Count--;
              
            if( data == '[') index3Count++;
            else if( data == ']') index3Count--;
                
        }
        
        if(index1Count == 0 && index2Count ==0 && index3Count == 0)
            return true;
     
        return false;
    }
    
     */
}
