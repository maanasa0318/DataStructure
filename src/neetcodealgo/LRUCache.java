package neetcodealgo;

import java.util.HashMap;

public class LRUCache {
	
	Node head = new Node(0, 0);
	Node tail = new Node(0, 0);
	HashMap<Integer, Node> map = new HashMap<>();
	int capacity;
	
	public LRUCache(int capacity) {
	    this.capacity = capacity;
	    head.next= tail;
	    tail.prev= head;
    }
    
    public int get(int key) {
    	if(map.containsKey(key)) {
    		Node node = map.get(key);
    		remove(node);
    		insert(node);
    		return node.val;
    	}else {
    		return -1;
    	}
    }
    
    private void insert(Node node) {
    	map.put(node.key, node);
    	Node headNext = head.next;
    	head.next = node;
    	node.prev = head;
    	node.next = headNext;
    	headNext.prev = node;
		
	}

	private void remove(Node node) {
		map.remove(node.key);
		Node prevNode = node.prev;
	    Node nodeNext = node.next;
	    prevNode.next = nodeNext;
	    nodeNext.prev = prevNode;
	}

	public void put(int key, int value) {
        if(map.containsKey(key)) {
        	remove(map.get(key));
        }
        if(map.size() == capacity) {
        	remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    
    class Node{
    	
    	Node prev;
    	Node next;
    	int key;
    	int val;
    	
    	public Node(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    }

}
