package edu.marist.ds;

public class Stack {

	private LinkedList elements = new LinkedList();


	public String pop() {

		if (elements.isNotempty()) {
			String value = elements.read(0);
			elements.remove(0);
			return value;
		}
		return null;
	}

	public void push(String value) { elements.prepend(value); }

	public Node search(String value) { return elements.searchNode(value); }

	public void clear() { elements.clear(); }

	public void printStack() { elements.printLinkedList(); }

}
