/*
    20. Merge Two Sorted Lists
 *  https://oj.leetcode.com/problems/merge-two-sorted-lists/
    
 *  206. Reverse Linked List
 *  https://leetcode.com/problems/reverse-linked-list/
 * 
 *  Reverse Integer
 *  http://www.jiuzhang.com/solutions/reverse-integer/
 * 
 */
#include<stdlib.h>
#include<stdio.h>

#include <cstdlib>
#include <iostream>
#include <map>
#include <vector>
#include <iterator>
#include <algorithm>
#include <cstring> // memset

using namespace std;

using std::vector;
using std::cout;


typedef struct node{
    int val;
    struct node *next;
    
} ListNode;


void addNodeToHead(int val, ListNode** list)
{
  ListNode *newnode = new ListNode;
  newnode->val = val;
  newnode->next = *list;
  *list = newnode;
}

void addNodeToTail(int val, ListNode** list)
{
  ListNode *newnode = new ListNode;
  newnode->val = val;
  newnode->next = NULL;
  
  ListNode *current = *list;
  while(current->next != NULL){
      current = current->next;
  }
  current->next = newnode;
  
}

void printListNode(ListNode* data)
{
  ListNode*current = data;
  while(current)
  {
    cout << "" << current->val << ",";
    current = current->next;
  }
  cout << endl;
}


class Solution 
{
    static Solution *_instance;  

public:
    Solution(){};
    ~Solution(){};
    
    static Solution& getInstance()
    {
        static Solution theInstance;
        _instance = &theInstance;
        return *_instance;
    }
    
    ListNode* mergeTwoSortedLists(ListNode* l1, ListNode* l2) 
    {    
        ListNode *dummy = new ListNode;
        ListNode *ptr = dummy;
        
        while (l1 != NULL && l2 != NULL)
        {
            if( l1->val < l2 ->val){
                ptr->next = l1;
                l1 = l1->next;
            }else {
                ptr->next = l2;
                l2 = l2->next;
            }
            ptr = ptr->next;
        }
        
        if(l1 != NULL) ptr->next = l1;
        else ptr->next = l2;
        
        return ptr;
    }
    
    void reverse(ListNode **head) {
        // Initial 3 ptrs
        ListNode *prev = NULL;
        ListNode *current = *head;
        ListNode *next = NULL;
        while (current != NULL) {
            next = current->next; 
            current->next = prev;
            prev = current;
            current = next;
        }
        *head = prev;
    }
    
    // ans: http://bangbingsyb.blogspot.jp/2014/11/leetcode-reverse-linked-list-ii.html
    /*
    ListNode* reverseBetween(ListNode** head, int m, int n) 
    {
        //ListNode *dummy = new ListNode;
        ListNode *ptr = dummy;
        while(head != NULL)
        {
            if(head->val== m) head->val= n;
            else if(head->val == n) head->val= m;
            
            ptr->val = head->val;
            ptr = ptr->next;
            head = head->next;
        }

        return ptr;
    }
    */
    
    // Input 123 --> 321
    //  rev = rev*10 + x%10 取餘數加上十進位
    //   3  =  0     +  3   
    //   32 = 3*10   +  2
    int reverseInt(int x) {
        int rev = 0;
        while(x != 0){
            rev = rev*10 + x%10; // 取餘數 加上乘以十進位
            x = x/10;           // 除以十進位來移位
        }
        return rev;
    }

};


//
//  Example
// Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
Solution * Solution::_instance = 0;

/*
int main(int argc, char** argv) {
     
    ListNode* l1 = new ListNode;
    ListNode* l2 = new ListNode;
    
    cout<< "####### l1 ######### "<< endl;
    addNodeToTail(1,&l1);        
    addNodeToTail(3,&l1);
    addNodeToTail(8,&l1);
    addNodeToTail(11,&l1);
    addNodeToTail(15,&l1);
    printListNode(l1);
    
    
    cout<< "####### l2 ######### " << endl;
    
    addNodeToTail(2,&l2);
    printListNode(l2);
     
    
    cout<< "####### Merge Sorted List ######### " << endl;
    ListNode* l3 = Solution::getInstance().mergeTwoSortedLists(l1, l2);
    printListNode(l3);
        
    cout<< "####### Reverse  ######### " << endl;
    Solution::getInstance().reverse(&l3);
    printListNode(l3);
    
    //cout<< "####### Reverse Between ######### " << endl;
    //ListNode* l4 = Solution::getInstance().reverseBetween(l3, 11, 3);
    //printListNode(l4);
    
    
    cout<< "####### Reverse Integer ######### " << endl;
    cout << Solution::getInstance().reverseInt(123);
    cout << Solution::getInstance().reverseInt(-123);
    return 0;
}
*/

