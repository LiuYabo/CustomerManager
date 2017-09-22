package edu.xidian.select;

public class BinarySearchST {
	int[] keys;
	String[] values;
	public BinarySearchST(int capacity) {
		this.keys = new int[capacity];
		this.values = new String[capacity];
	}
	
	public String get(int key) {
		
	}
	
	public int rank(int key, int low, int high) {
		
		if (low >= high) {
			return low;
		}
		int mid = (low + high)/2;
		if (key < keys[mid]) {
			low = low;
			high = mid;
			rank(key, low, mid);
		}
		else if (key > keys[mid]) {
			low = mid;
			high = high;
			rank(key, low, high);
		}
		else {
			return mid;
		}     
	}
	
	public class Node {
		private int key;
		private String value;
		private Node left;
		private Node right;
		
		public Node(int key, String value) {
			this.key = key;
			this.value = value;
		}
		
		
	}
	
	public String get(Node root, int key) {
		if (root ==  null) 
			return null;
		if (root.key > key)
			return get(root.left, key);
		if (root.key < key)
			return get(root.right, key);
		else
			return root.value;
	}
	
	public Node put(Node root, int key, String value) {
		if (root == null) 
			return new Node(key, value);
		else if (key <  root.key) {
			root.left = put(root.left, key , value);
		}
		else if (key > root.key) {
			root.right = put(root.right, key, value);
		}
		else 
			root.value = value;
		return root;
	}

	
	
	
}
