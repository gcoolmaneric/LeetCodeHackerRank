#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cmath>
using namespace std;

struct Node
{
    int data;
    Node* next;
    Node* prev;
};

/*
struct Node
{
    int data;
    Node* next;
};
 
   Find merge point of two linked lists
   Node is defined as
   struct Node
   {
       int data;
       Node* next;
   }
*/

/*
Test Case 

A B C D E 
F G C 

B C E
G D C 

B E 
G D C E 

 */

/*
// OK  Log( M + N ) = Log(N) 
int FindMergeNode(Node *headA, Node *headB)
{
    if( headA == NULL || headB == NULL ) return 0;
    
    Node *ptrA = headA->next, *ptrB = headB->next;  
    int checkId[1000];
    for(int i=0; i < 1000; i++)
        checkId[i] = 0;
    
    while( ptrA )
    {
        checkId[ptrA->data] += 1;
        ptrA = ptrA->next;
    }
    while( ptrB )
    {
        if(checkId[ptrB->data]) 
           return ptrB->data;
        ptrB = ptrB->next;
    }
        
    return 0;
}
*/

/*
// OK  Log( MxN ))
int FindMergeNode(Node *headA, Node *headB)
{
    if( headA == NULL || headB == NULL ) return 0;
    
    Node *ptrA = headA->next, *ptrB = NULL;
    
    while( ptrA )
    {
        ptrB = headB->next;
        while(ptrB)
        {
            if( ptrA->data == ptrB->data )
                return ptrA->data;
            ptrB = ptrB->next;
        }
        
        ptrA = ptrA->next;
    }
    
    return 0;
}
*/

/*
#include <stack>
int FindMergeNode(Node *headA, Node *headB)
{
    // Complete this function
    // Do not write the main method. 
    stack<Node *> sta, stb;
    if(headA == NULL || headB == NULL)
        return 0;
    Node *cur = headA;
    while(cur != NULL)
    {
        sta.push(cur);
        cur = cur->next;
    }
    cur = headB;
    while(cur != NULL)
    {
        stb.push(cur);
        cur = cur->next;
    }
    int last = 0;
    while(!sta.empty() && !stb.empty())
    {
        Node *pa = sta.top();
        Node *pb = stb.top();
        sta.pop();
        stb.pop();
        if(pa->data != pb->data)
        {
            break;
        }
        else last = pa->data;
    }
    return last;
}
*/

/*
Test Case 

A B C D E 
F G C 

B C E
G D C 

B E 
G D C E 

 */

/*
int main()
{
    Node *A, *B, *C, *D,*E,*F,*G;
    A = new Node(); B= new Node();  C= new Node(); D = new Node(); E = new Node(); F= new Node();G = new Node();
    A->data = 2; B->data = 4; C->data = 3; D->data = 5; E->data = 7; F->data = 6;G->data = 11;
 
    // case 1 = 
    A->next = B; B->next = C; C->next = D; D->next = E; E->next = NULL;
    F->next = G; G->next = C;
    cout<<FindMergeNode(A,F)<<"\n";
    //case 2.
    A->next = B; B->next = C; C->next = E;  E->next = NULL;
    F->next = G; G->next = D;D->next = C;
    cout<<FindMergeNode(A,F)<<"\n";
    //case 3:
    A->next = B; B->next = E; E->next = NULL;
    F->next = G; G->next = D;D->next = C; C->next = E;
    cout<<FindMergeNode(A,F)<<"\n";
}
 * */


Node* SortedInsert(Node *head,int data)
{
    Node *current = head, *prev = head;
       
    // Insert into the head 
    if(current == NULL)
    {
        Node *newData = new Node;
        newData->data = data;
        newData->prev = NULL;
        newData->next = NULL;
        current= newData;
        return current;
        
    }else {
        
        while(current)
        {
            if(data < current->data)
            {
                Node *ptr = new Node;
                ptr->data = data;
                ptr->next = current->prev;
                prev->next = ptr->prev;
            }
            prev = current;
            current = current->next;
            
        }
         return head;
    }
    
}

/*
int main()
{
    Node *A, *B, *C, *D,*E,*F,*G;
    A = new Node(); B= new Node();  C= new Node(); D = new Node(); E = new Node(); F= new Node();G = new Node();
    A->data = 2; B->data = 4; C->data = 6; D->data = 5; E->data = 7; F->data = 6;G->data = 11;

    A->next = B; B->next = C; C->next;
    cout<< SortedInsert(A,5)<<"\n";
}
*/
