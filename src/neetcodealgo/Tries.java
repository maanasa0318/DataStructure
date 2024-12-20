package neetcodealgo;

import java.util.HashMap;

public class Tries {

	class TrieNode{
		private boolean isword;
		private HashMap<Character, TrieNode> childern = new HashMap<>();
		
	}
	
	TrieNode root;
	
	public Tries(){
		root = new TrieNode();
	}
	
    public void insert(String word) {
    	TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
    		if(!curr.childern.containsKey(c)) {
    			curr.childern.put(c, new TrieNode());
    		}
    		//move curr char to new node which just inserted
    		curr = curr.childern.get(c);
    	}
        curr.isword = true;
    }
    
    public boolean search(String word) {
    	TrieNode curr = this.root;
    	for(char c : word.toCharArray()) {
    		if(!curr.childern.containsKey(c)) {
    			return false;
    		}
    		curr = curr.childern.get(c);
    	}
    	return curr.isword;
    }
    
    public boolean startsWith(String prefix) {
    	TrieNode curr = this.root;
    	for(char c : prefix.toCharArray()) {
    		if(!curr.childern.containsKey(c)) {
    			return false;
    		}
    		curr = curr.childern.get(c);
    	}
    	return true;
    }
}
