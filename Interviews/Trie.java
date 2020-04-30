package Interviews;

import java.util.ArrayList;
import java.util.List;

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
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String word : this.listOfWords) {
            if (word.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

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