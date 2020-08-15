/*
Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Note:
Assume the length of given string will not exceed 1,010.
Example:
Input:
"abccccdd"
Output:
7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/
class Solution {
    public int longestPalindrome(String s) {
        int count[] = new int[128];
        int len = 0;
        for(char ch : s.toCharArray()){
            if(++count[ch] == 2){
                len += 2;
                count[ch] = 0;
            }
        }
        return (s.length() == len)? len : len + 1;
    }
}