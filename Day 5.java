/*
Add and Search Word - Data structure design
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/
class WordDictionary {
class Node{
    char c;
    Map<Character,Node> map;
    boolean b ;
    Node(char c){
        this.c = c;
        this.map = new HashMap<>();
    }
}
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node('\0');
    }    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            Node temp = node.map.get(ch);
            if(temp == null){
                temp = new Node(ch);
                node.map.put(ch,temp);
            }
            node = temp;
        }
        node.b = true;
    }    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchTrie(word,root,0);
    }
    private boolean searchTrie(String word,Node root,int index){
        if(index >= word.length())
            return root.b;
        char ch = word.charAt(index);
        if(ch == '.'){
            for(Node node : root.map.values()){
                if(root != null && searchTrie(word,node,index + 1))
                    return true;
            }
            return false;
        }
        if(root == null || !root.map.containsKey(ch))
            return false;
        return searchTrie(word,root.map.get(ch),index + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */