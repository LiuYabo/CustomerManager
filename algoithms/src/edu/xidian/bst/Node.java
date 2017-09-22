package edu.xidian.bst;

public class Node {
	int key;
    String value;
    public Node left;
    public Node right;
	 

    public Node(int key, String value, Node left, Node right) {
         this.key = key;
         this.value = value;
    }
}
