/*
    3.15 Length of Last Word
 * 
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length
    of last word in the string.
    If the last word does not exist, return 0.
    Note: A word is defined as a character sequence consists of non-space characters only.
    For example, Given s = "Hello World", return 5.
 *  
 *  Idea: reverse string and find the first position of white space and 
 *  extract the string. 
 * 
 *  7.2 :  Search Insert Position binarySeach
 * 
 */

#include <cstdlib>
#include <iostream>
#include <map>

#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

using std::vector;
using std::cout;



// TODO
/*
int Palindrome(int x) {
    int ret = 0;
    int front =0, end=0;
    while( x != 0 )
    {   
        end = x%10;
        front = fro/10;
    }
    return ret;
}
*/

int reverse(int x) {
    int ret = 0;
    while( x != 0 )
    {
        if( abs(ret) > 214748364 ) 
            return 0; 
        ret = ret*10 + x%10;
        x /= 10;
    }
    return ret;
}

int searchInsert(string input, int target) {
    
    if( input.length() == 0 ) return 0;
    
    char *A = const_cast<char*>(input.c_str());
    int L = 0, R = input.length() - 1;
    
    while (L < R) {
        int M = (L + R) / 2;    
        int chk = A[M] - '0';
        if ( chk < target) {
            L = M + 1;
        } else {
            R = M;
        }
    }
    return (A[L] < target) ? L + 1 : L;
}

int binarySeach(string input, int key, int low, int high)
{    
   if( input.length() == 0 ) return 0;
   if(low > high ) return -1;
        
   char *ptr = const_cast<char*>(input.c_str());
   int mid = low + ( low + high ) / 2;
   int chk = ptr[mid] - '0';
   
   if( chk == key ) 
       return mid;
   else if( chk > key ) 
       return binarySeach(input, key, low, mid-1);
   else  
       return binarySeach(input, key, mid+1, high);
}

int lengthOfLastWord(string input)
{
    int count = 0;
    int totalLen = 0;
    
    if( input.length() == 0 ) return 0;
    totalLen = input.length();
    
    char *ptr = const_cast<char*>(input.c_str());
    ptr += totalLen-2;
    
    count= 1;
    while(*ptr)
    {   
        if(iswspace(*ptr)) break;
        count++;
        ptr--;
    }   
    return count;
}

/*
int main(int argc, char** argv) {
  
    //cout << "## lengthOfLastWord: " << lengthOfLastWord("Hello World Eric6waves") << endl; 
    
    
    cout << "## binarySeach: " << binarySeach("987654321", 5, 0, 9) << endl; 
    
    //cout << "## binarySeach: " << binarySeach("1356", 5, 0, 4) << endl; 
    
    cout << "## searchInsert: " << searchInsert("1356", 5) << endl;
     
    cout << "## reverse: " << reverse(123) << endl;
    cout << "## reverse: " << reverse(-123) << endl;
 
      
    return 0;
}
*/


