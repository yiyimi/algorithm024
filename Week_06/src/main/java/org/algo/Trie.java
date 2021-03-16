package org.algo;

public class Trie {

    private Trie[] next;

    private final int R = 26;

    private boolean isEnd;


    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[R];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie trie = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            int idx = words[i] - 'a';
            if (trie.next[idx] == null) {
                trie.next[idx] = new Trie();
            }
            trie = trie.next[idx];
        }
        trie.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = searchPrefix(word);
        return curr != null && curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = searchPrefix(prefix);
        return curr != null;
    }

    private Trie searchPrefix(String word) {
        Trie trie = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            trie = trie.next[words[i] - 'a'];
            if (trie == null) return null;
        }
        return trie;
    }
}
