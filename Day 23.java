/*
Stream of Characters
Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.
*/
class StreamChecker {       
    
     StringBuilder sb; 
     Trie root;

    public StreamChecker(String[] words) {
        sb = new StringBuilder(); 
        root = new Trie(); 
        for(String s: words)
            insert(s);        
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        Trie node = root;
        for(int i = sb.length() - 1;i >= 0 && node != null;i--){
            char ch = sb.charAt(i);
            node = node.map.get(ch);
            if(node != null && node.leaf)
                return true;
        }
        return false;
        
    }
    class Trie{
    Map <Character,Trie> map;
    boolean leaf;
    public Trie(){
        map = new HashMap<>();
       // leaf = false;
    } 
    }
    public void insert(String str){
        Trie node = root;
        for(int i = str.length() - 1;i >= 0;i--){
            char ch = str.charAt(i);
            Trie temp = node.map.getOrDefault(ch,new Trie());
            node.map.put(ch,temp);            
            node = temp;
        }
        node.leaf = true;
    }
}
/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */