/*
Excel Sheet Column Number
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:
Input: "A"
Output: 1
Example 2:
Input: "AB"
Output: 28
Example 3:
Input: "ZY"
Output: 701
Constraints:
1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".
*/
class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        if(n == 0)
            return 0;        
        int val = 0;        
        for(char ch :s.toCharArray()){
            //System.out.print(s.charAt(i)-'a');
            val = val * 26 + (ch - 'A' + 1);
            System.out.print(val);
        }
        return val;
    }
}