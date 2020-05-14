package Interviews;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/implement-trie-prefix-tree/solution/

public class Trie {

    public List<String> listOfWords;

    /** Initialize your data structure here. */
    public Trie() {
        this.listOfWords = new ArrayList<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (!search(word)) {
            this.listOfWords.add(word);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.listOfWords.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (String word : this.listOfWords) {
            if (word.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public class FastTrieNode {

        private FastTrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public FastTrieNode() {
            this.links = new FastTrieNode[26];
        }

        public boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        public FastTrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, FastTrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////

    class FastTrie {
        private FastTrieNode root;

        public FastTrie() {
            root = new FastTrieNode();
        }

        public void insert(String word) {
            FastTrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new FastTrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        private FastTrieNode searchPrefix(String word) {
            FastTrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

        public boolean search(String word) {
            FastTrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        public boolean startsWith(String prefix) {
            FastTrieNode node = searchPrefix(prefix);
            return node != null;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Trie testCase1 = new Trie();
        System.out.println("Expected: false :: Actual: " + testCase1.search("apple"));
        testCase1.insert("apple");
        System.out.println("Expected: true :: Actual: " + testCase1.search("apple"));
        System.out.println("Expected: false :: Actual: " + testCase1.search("app"));
        System.out.println("Expected: true :: Actual: " + testCase1.startsWith("app"));
        testCase1.insert("app");
        System.out.println("Expected: true :: Actual: " + testCase1.search("app"));

    }
}
