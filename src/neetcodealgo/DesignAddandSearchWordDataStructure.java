package neetcodealgo;

import java.util.HashMap;
import java.util.Map.Entry;

public class DesignAddandSearchWordDataStructure {

	class TrieNode {
		boolean match = false;
		HashMap<Character, TrieNode> child = new HashMap<>();
	}

	TrieNode node;

	public DesignAddandSearchWordDataStructure() {
		this.node = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode curr = this.node;
		for (char c : word.toCharArray()) {
			if (!curr.child.containsKey(c)) {
				curr.child.put(c, new TrieNode());
			}
			curr = curr.child.get(c);
		}
		curr.match = true;
	}

	public boolean search(String word) {
		return dfs(word, 0, node);
	}

	public boolean dfs(String word, int j, TrieNode node) {
		TrieNode curr = node;
		HashMap<Character, TrieNode> children = node.child;
		for (int i = j; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (TrieNode childNode : children.values()) {
					if (childNode!= null && dfs(word, i + 1, childNode)) {
						return true;
					}
					return false;
				}
				
			} else {
				if (!curr.child.containsKey(c)) {
					return false;
				}
				curr = curr.child.get(c);
			}
		}
		return curr.match;
	}
}
