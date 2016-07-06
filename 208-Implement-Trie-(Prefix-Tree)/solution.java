class TrieNode {
    // Initialize your data structure here.
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean hasWord = false;
    
    public TrieNode() {
        
    }
    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        char[] chars =word.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(children.containsKey(c)) {
                cur = children.get(c);
            } else {
                TrieNode newNode = new TrieNode(c);
                children.put(c, newNode);
                cur = newNode;
            }
            children = cur.children;
            
            if(i == chars.length - 1) {
                cur.hasWord = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        int i = 0;
        for(; i < word.length(); i++) {
            char c = chars[i];
            if(cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                break;
            }
        }
        return i == word.length() && cur.hasWord;
            
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        int i = 0;
        for(; i < prefix.length(); i++) {
            char c = chars[i];
            if(cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                break;
            }
        }
        return i == prefix.length();
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");