package edu.marist.ds;

public class Node implements Comparable<Node> {

	private String value;
	private Node   prev;
	private Node   next;

    public Node()
    {


    }
	public Node(String value) {

		this.value = value;
	}

	public String getData() { return value; }

	public void setData(String value) { this.value = value; }

	public Node getPrev() { return prev; }

	public void setPrev(Node prev) { this.prev = prev; }

	public Node getNextNode() { return next; }

	public void setNextNode(Node next) { this.next = next; }

	@Override
	public int compareTo(Node n) { return this.value.compareTo(n.value); }

	@Override
	public String toString() { return String.valueOf(this.value); }

}
