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
public class ReverseLinkedList {
    
     public static class ListNode {
            int _data;
            ListNode _next;

            ListNode(int head){
                _data = head;
            }
     }

    public static class LinkList {

       private ListNode first;

       LinkList(){}

       public void insterFirst(int dd)
       {
           ListNode newLink = new ListNode(dd);
           newLink._next = first;
           first = newLink;
       }

       public ListNode deleteFirst()
       {
           ListNode temp = first;
           first = first._next;
           return temp;
       }
       
       public void displayList()
       {
           ListNode current = first;
           while(current != null)
           {
               System.out.println("" + current._data);
               current = current._next;
           }
       }
       
       public LinkList reverseList2()
       {
           LinkList newlist = new LinkList();
            
           ListNode current = first;
           while(current!= null)
           {
               newlist.insterFirst(current._data);
               current = current._next;
           }
           
           return newlist;
       }

    }

    // Iterative
    public ListNode IterativeReverseList(ListNode head) 
    {
       if(head._data == 0 || head._next == null) {
           return head;
       }
       
       ListNode ans = head;
       ListNode todo = head._next;
       
       ans._next = null;
       while(todo != null)
       {
           ListNode temp = todo;
           todo = todo._next;
           
           temp._next = ans;
           ans = temp;
       }
       
       return ans;
    }
 
    
      // Recursive
    public ListNode RecursiveReverseList(ListNode head) 
    {
       if(head._data == 0 || head._next == null) {
           return head;
       }
       // Get Second node
       ListNode second = head._next;
       // set first`s next to be null
       head._next = null;
       
       ListNode rest = RecursiveReverseList(second);
       second._next = head;
       
       return rest;
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkList list = new LinkList();
           
        list.insterFirst(1);
        list.insterFirst(2);
        list.insterFirst(3);
        list.insterFirst(4);
        list.displayList();
       
        LinkList newlist = list.reverseList2();
        newlist.displayList();
        
        int temp = 10%3;
        System.out.println("#### " + temp);
    }
   
    
}
