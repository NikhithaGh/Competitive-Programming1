public class Solution {

    // implement a trie and use it to efficiently store string
    
    
    static class Trie {
        static final int ALPHABET_SIZE = 26;
     
        
        static class TrieNode
        {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];
      
            // isEndOfWord is true if the node represents
            // end of a word
            boolean isEndOfWord;
         
            TrieNode(){
                isEndOfWord = false;
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        }
        static TrieNode root; 
        static boolean insert(String key)
        {
            int level;
            int length = key.length();
            int index;
            if(root == null)
                root = new TrieNode();
            TrieNode pCrawl = root;
            
            for (level = 0; level < length; level++)
            {
                index = key.charAt(level) - 'a';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();
      
                pCrawl = pCrawl.children[index];
            }
      
            boolean result = pCrawl.isEndOfWord;
            pCrawl.isEndOfWord = true;
            return !result;
        }
        public boolean addWord(String word) {
            boolean r = insert(word);
            System.out.println("result for word "+word+": "+r);    
            return r;
        }
    }

    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.addWord("catch");
        trie.addWord("cakes");
        trie.addWord("cake");
        trie.addWord("caked");
        trie.addWord("catch");
       
    }
}