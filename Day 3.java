/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.
Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:
Input: "race a car"
Output: false
Constraints:
s consists only of printable ASCII characters.
*/
class Solution {
    public boolean isPalindrome(String s) {s = s.replaceAll("[^a-zA-Z0-9]","");        
        int l = 0, r = s.length() - 1;
        while(l<r){
            if(!Character.toString(s.charAt(l)).equalsIgnoreCase(Character.toString(s.charAt(r))))
                return false;
            l++;
            r--;
        }        
        return true;
    }
}