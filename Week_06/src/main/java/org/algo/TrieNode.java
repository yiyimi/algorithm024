package org.algo;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public String word = null;
    public TrieNode() {}
}
