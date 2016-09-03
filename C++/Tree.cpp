/* Binary Tree Traversal - Preorder, Inorder, Postorder */
#include<iostream>
#include<stack>

using namespace std;
 
struct Node {
	char data;
	struct Node *left;
	struct Node *right;
};


//Function to visit nodes in Preorder
void PreorderNoneRescursive(struct Node *root) {
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
	if(root == NULL) return;
        
        stack<Node*> s;
        
        while(1)
        {
            while(root)
            {
                cout << root->data << endl;
                s.push(root);
                root = root->left;
            }
            
            while(s.empty()) 
                return;
            
            root = s.top();
            s.pop();
            root = root->right;
        }
}


//Function to visit nodes in Preorder
void Preorder(struct Node *root) {
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
	if(root == NULL) return;

	cout << root->data << endl; // Print data
	Preorder(root->left);     // Visit left subtree
	Preorder(root->right);    // Visit right subtree
}

void InorderNoneRescursive(struct Node *root) {
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
	if(root == NULL) return;
        
        stack<Node*> s;
        
        while(1)
        {
            while(root)
            {
                s.push(root);
                root = root->left;
            }
            
            while(s.empty()) 
                return;
            
            root = s.top();
            cout << root->data << endl;
            s.pop();
            root = root->right;
        }
}


//Function to visit nodes in Inorder
void Inorder(Node *root) {
	if(root == NULL) return;

	Inorder(root->left);       //Visit left subtree
	cout << root->data << endl; // Print data
	Inorder(root->right);      // Visit right subtree
}

void PostorderNoneRescursive(struct Node *root) {
    stack<Node*> s1;
    stack<Node*> s2;
    
    s1.push(root);
    
    while(!s1.empty())
    {
        Node *tmp = s1.top();
        s1.pop();
        s2.push(tmp);
        
        if(tmp->left)  s1.push(tmp->left);
        if(tmp->right) s1.push(tmp->right);
    }
    
    while(!s2.empty())
    {
        cout << s2.top()->data << endl;
        s2.pop();
    }
}

//Function to visit nodes in Postorder
void Postorder(Node *root) {
	if(root == NULL) return;

	Postorder(root->left);    // Visit left subtree
	Postorder(root->right);   // Visit right subtree
	cout << root->data << endl; // Print data
}

// Function to Insert Node in a Binary Search Tree
Node* Insert(Node *root,char data) {
	if(root == NULL) {
		root = new Node();
		root->data = data;
		root->left = root->right = NULL;
	}
	else if(data <= root->data)
		root->left = Insert(root->left,data);
	else 
		root->right = Insert(root->right,data);
	return root;
}

// Function to Insert Node in a Binary Search Tree
Node* InsertNonrecursive(Node *root,char data) 
{	 
        // Add node to root    
        if(root == NULL) 
        {
            root = new Node();
            root->data = data;
            root->left = root->right = NULL;
		}
	
        Node *ptr = root;
        while(ptr)
        {
            // Add node to left subtree
            if(data < ptr->data)
            {
                if(ptr->left)
                    ptr = ptr->left;
                else {
                    ptr->left = new Node();
                    ptr->left->data = data;
                    ptr->left->left = ptr->left->right = NULL;
                    break;
                }
            }
            // Add node to right subtree
            if(data > ptr->data)
            {
                if(ptr->right)
                    ptr = ptr->right;
                else {
                    ptr->right = new Node();
                    ptr->right->data = data;
                    ptr->right->left = ptr->right->right = NULL;
                    break;
                }
            }
        }
        return root;
}
 

int main() {
	/*Code To Test the logic
	  Creating an example tree
	                    M
			   / \
			  B   Q
			 / \   \
			A   C   Z
    */
	Node* root = NULL;
	
        // Recursive insert
        root = Insert(root,'M'); root = Insert(root,'B');
	root = Insert(root,'Q'); root = Insert(root,'Z'); 
	root = Insert(root,'A'); root = Insert(root,'C');
        
        // Non-recursive insert
        //root = InsertNonrecursive(root,'M'); root = InsertNonrecursive(root,'B');
	//root = InsertNonrecursive(root,'Q'); root = InsertNonrecursive(root,'Z'); 
	//root = InsertNonrecursive(root,'A'); root = InsertNonrecursive(root,'C');
        
	//Print Nodes in Preorder. 
	cout<<"Preorder: ";
	Preorder(root);
	cout<<"\n";
        cout<<"None Recursive Preorder: ";
        PreorderNoneRescursive(root);
	cout<<"\n";
        
	//Print Nodes in Inorder
	cout<<"Inorder: ";
	Inorder(root);
	cout<<"\n";
        cout<<"None Recursive Inorder: ";
        InorderNoneRescursive(root);
	cout<<"\n";
        

	//Print Nodes in Postorder
	cout<<"Postorder: ";
	Postorder(root);
	cout<<"\n";
        cout<<"None Recursive Postorder: ";
        PostorderNoneRescursive(root);
	cout<<"\n";
        
}