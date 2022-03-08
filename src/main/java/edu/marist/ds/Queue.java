package edu.marist.ds;

public class Queue {

	private LinkedList elements = new LinkedList();


	public String dequeue() {

		if (elements.isNotempty()) {
			String value = elements.read(0);
			elements.remove(0);
			return value;
		}
		else{
            return null;
        }
	}

	public void enqueue(String value) { elements.append(value); }

	public Node search(String value) { return elements.searchNode(value); }

	public void clear() { elements.clear(); }

	public void printQueue() { elements.printLinkedList(); }

}
