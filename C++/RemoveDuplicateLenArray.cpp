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

#include <cstdlib>
#include <iostream>
#include <map>

#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

using std::vector;
using std::cout;

int removeDupLenArray(vector<int>& test)
{
	if (test.size() == 0) return 0;

	int index = 0;
	for (int i = 0; i < test.size(); ++i)
	{
		if (test[index] != test[i])
			test[index++] = test[i];
	}
	return index + 1;
}


/*
int main(int argc, char** argv) {
    
    int input[] = { 1, 1, 1, 2, 2, 3 };
    std::vector<int> v (input, input + sizeof(input) / sizeof(int) );
    
    cout << "## removeDupLenArray: " << removeDupLenArray(v) << endl;
    
    return 0;
}
*/

