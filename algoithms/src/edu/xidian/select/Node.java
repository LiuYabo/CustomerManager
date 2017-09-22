package edu.xidian.select;

public class Node {
	int key;
	String value;
	Node next;
	
	public Node(int key, String value, Node next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public String get(int key) {
		for (Node node = first; node != null; node = node.next) {
			if (node.key == key) {
				return value;
			}
		}
		return null;
	}
	
	public void put(int key, String value) {
		for (Node node = first; node != null; node = node.next) {
			if (node.key == key) {
				node.value = value;
			}
		}
		first = new Node(int key, String value);
	}
	
	
	
}
