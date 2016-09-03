/*
    2.1.6 Longest Consecutive Sequence

    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1,
    2, 3, 4]. Return its length: 4.
    Your algorithm should run in O(n) complexity.
    
 * Analysis :
 *  Use hash to solve the problem because of unsorted array and required O(n)
 *  complexity. Loop through the array and check each element.
 *  Check element`s right and left side`s  value in hashamp 
 *  whether it has Consecutive integer.
 */

/*
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

#define MAX(a,b) (((a)>(b))?(a):(b))

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
    
    //  Longest Substring Without Repeating Characters
    //  http://www.lintcode.com/problem/longest-substring-without-repeating-characters/
    //
    // Given a string, find the length of the longest substring without repeating characters. 
    // For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
    // which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1
    int lengthOfLongestSubstring(string s)
    {
        int max = 0, left=0, len = s.length();      // left : record left boundary
        int last[256];                              // Position : last appearing position
        memset(last, -1, sizeof last);

        for(int i=0; i < s.length(); i++)
        {
            if(last[s[i]] >= left ) left = last[s[i]] + 1;  
            last[s[i]] = i;
            max = MAX(max, i - left + 1);
        }
        return max;
    }
    
    int LCS1(vector<int>& num)
    {
        map<int, bool> hashmap;

        for(int i=0; i < num.size(); i++)
            hashmap[num[i]] = true;

        int max = 0;
        for(int i=0; i < num.size(); i++)
        {
            int up = num[i];
            while(hashmap.find(up) != hashmap.end()){
                hashmap.erase(up);
                up++;
            }

            int down = num[i] - 1;
            while(hashmap.find(down) != hashmap.end()){
                hashmap.erase(down);
                down--;
            }
            if( up - down - 1 > max ) {
                max = up - down - 1;
            }
        }

        return max;
    }
     
};


Solution * Solution::_instance = 0;
 
int main(int argc, char** argv) {
    
    //int arr[] ={ 100, 4, 200, 1, 3, 2 };
    //std::vector<int> v (arr, arr + sizeof(arr) / sizeof(int) );
    //cout << "## LCS1: " << LCS1(v) << endl;
   
    // 2.1.6 
    string v = "bbbbb";
    cout << "## lengthOfLongestSubstring: " << Solution::getInstance().lengthOfLongestSubstring(v);
    
    
    
    return 0;
}
*/

