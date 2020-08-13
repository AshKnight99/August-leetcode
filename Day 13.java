/*
Design an Iterator class, which has:
A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
Example:
CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 
Constraints:
1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
*/
class CombinationIterator {
    List<String> list;
    int c_len;
    String s;
    int pointer;
    public CombinationIterator(String characters, int combinationLength) {
        s = new String (characters);
        c_len = combinationLength;
        list = new ArrayList<>(); 
        combinations(0,s,"");
        pointer = 0;
    }
    private void combinations(int index,String str,String comb){
        if(comb.length() == c_len){
            list.add(comb);
            return ;            
        }
        if(index < str.length()){
            for(int i = index ; i < str.length();i++)
                combinations(i + 1,str,comb + String.valueOf(str.charAt(i)));           
        }
    }    
    public String next() {        
            return list.get(pointer++);
    }    
    public boolean hasNext() {
        if(list.size() == pointer)
            return false;
        return true;        
    }
}
/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */