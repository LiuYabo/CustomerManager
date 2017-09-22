package edu.xidian.bst;

public class Operation {
	public Node minRecursion(Node root) {
		if (root.left == null) 
			return root;
		else 
			return minRecursion(root.left);
	}
	
	public Node maxRecursion(Node root) {
		if (root.right == null)
			return root;
		else
			return maxRecursion(root.right);
	}
	
	public Node floor(Node root, int key) {
		if (root == null) 
			return null;
		else if (key < root.key) 
			return floor(root.left, key);
		else if (key == root.key) 
			return root;
		else 
			return floor(root.right, key);
	}
	
	
	public void deletMin (Node root) {
		if (root == null);
			
	}
	
	public void print(Node root) {
		if (root == null) 
			return;
		print(root.left);
		System.out.println(root.value);
		print(root.right);
	}
	
	
	
	
	
	
	
	
	
}