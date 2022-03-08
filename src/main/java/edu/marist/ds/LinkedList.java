package edu.marist.ds;

public class LinkedList {

	private Node head;
	private Node last;
	private int  size;


	private void insertFirst(Node node) {

		if (head != null) {
			head.setPrev(node);
			node.setNextNode(head);
		}

		node.setPrev(null);
		head = node;
		last = last == null ? head : last;
		size++;
	}

	private void insertLast(Node node) {

		if (last != null) {
			last.setNextNode(node);
			node.setPrev(last);
		}
		last = node;
		last.setNextNode(null);
		head = head == null ? last : head;
		size++;
	}

	public void prepend(String data) {

		insertFirst(new Node(data));
	}

	public void append(String data) {

		Node newNode = new Node(data);

		if (head == null) {
			insertFirst(newNode);
		} else {
			insertLast(newNode);
		}
	}

	public void insert(int index, Node newNode) {

		//Node newNode = new Node(value);

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(index);
		} else {

            if(newNode== null){
            }

			else if (index == size) {
				insertLast(newNode);

			}
            else if (index == 0) {
				insertFirst(newNode);
			}
            else{
				Node current = head;
				Node temp = null;

				for (int i = 0; i < index; i++) { current = current.getNextNode(); }
				temp = current.getNextNode();
				temp.setPrev(current);

				current.setNextNode(newNode);
				newNode.setPrev(current);
				newNode.setNextNode(temp);
				temp.setPrev(newNode);
				size++;
			}
		}

	}

	public void remove(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		} else {

			if (index == 0) {
				head = head.getNextNode();
			} else if (index == size - 1) {
				last = last.getPrev();
			} else {
				Node current = head;

				for (int i = 0; i < index; i++) { current = current.getNextNode(); }
				current.getNextNode().setPrev(current.getPrev());
				current.getPrev().setNextNode(current.getNextNode());
			}
			size--;
		}
	}

	public String read(int index) {

		if (index < 0 || index >= size) {
			return null;
		} else {

			if (index == 0) {
				return head.getData();
			} else if (index == size - 1) {
				return last.getData();
			} else {
				Node current = head;

				for (int i = 0; i < index; i++) { current = current.getNextNode(); }
				return current.getData();
			}
		}
	}

	public int search(String value) {

		Node current = head;
		int index = 0;

		while (current != null) {

			if (current.getData().equals(value)) { return index; }
			current = current.getNextNode();
			index++;
		}
		return -1;
	}

	public Node searchNode(String value) {

		Node current = head;

		while (current != null) {

			if (current.getData().equals(value)) { return current; }
			current = current.getNextNode();
		}
		return null;
	}

	public void clear() { head = last = null; }

	public int getSize() { return size; }

	public boolean isNotempty() { return size > 0; }

	public void printLinkedList() { System.out.println(this.toString()); }

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		if (isNotempty()) {
			Node node = head;

			while (true) {
				sb.append(node);
				node = node.getNextNode();

				if (node != null) {
					sb.append(", ");
				} else {
					break;
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
