package edu.marist.ds;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for hello world App template.
 */
class Assignment1Test {
    @Test
    void testEmptyNode() {
        // test empty node
        Node testNode = new Node();
        assertEquals(null, testNode.getData());
        assertEquals(null, testNode.getNextNode());
    }

    @Test
    void testNodeData() {
        // test constructor initializing with node
        String nodeData = "testNode1";
        Node testNode1 = new Node(nodeData);

        // check set and get data
        assertEquals(nodeData, testNode1.getData());
        String string2 = "newData";
        testNode1.setData(string2);
        assertEquals(string2, testNode1.getData());
    }

    @Test
    void testNodeNext() {
        Node testNode1 = new Node("Mike");
        Node testNode2 = new Node();
        testNode1.setNextNode(testNode2);
        assertEquals(testNode2, testNode1.getNextNode());
    }

    @Test
    void testEmptyLinkedList() {
        LinkedList linkList1 = new LinkedList();
        assertEquals(-1, linkList1.search("data"));
        assertEquals(null, linkList1.read(0));
        linkList1.append(null);
        assertEquals(null, linkList1.read(0));
        linkList1.insert(0, null);
        assertEquals(null, linkList1.read(0));
        linkList1.remove(0);
    }

    @Test
    void testLinkedList() {
        Node testNode1 = new Node("1");
        Node testNode2 = new Node("2");
        Node testNode3 = new Node("3");
        Node testNode4 = new Node("4");
        LinkedList linkList1 = new LinkedList();
        linkList1.printLinkedList();
        assertEquals(null, linkList1.read(0));
        linkList1.insert(0, testNode1);
        linkList1.insert(1, testNode2);
        linkList1.insert(2, testNode3);
        assertEquals(testNode1.getData(), linkList1.read(0));
        assertEquals(testNode3.getData(), linkList1.read(2));
        linkList1.insert(0, testNode4);
        assertEquals(testNode4.getData(), linkList1.read(0));
        linkList1.remove(0);
        assertEquals(testNode1.getData(), linkList1.read(0));
        linkList1.remove(2);
        assertEquals(null, linkList1.read(2));
        linkList1.printLinkedList();
    }

    @Test
    void testLinkSearchList() {
        Node testNode1 = new Node("1");
        Node testNode2 = new Node("2");
        Node testNode3 = new Node("3");
        LinkedList linkList1 = new LinkedList();
        linkList1.insert(0, testNode3);
        linkList1.insert(0, testNode2);
        linkList1.insert(0, testNode1);
        assertEquals(0, linkList1.search(testNode1.getData()));
        assertEquals(1, linkList1.search(testNode2.getData()));
        assertEquals(2, linkList1.search(testNode3.getData()));
        assertEquals(-1, linkList1.search("99"));
    }

    @Test
    void testEmptyStack() {
        Stack s = new Stack();
        assertEquals(null, s.pop());
        assertEquals(null, s.search(""));
        s.push("0");
        assertEquals(null, s.search("0").getNextNode());
        assertEquals("0", s.search("0").getData());
        assertEquals("0", s.pop());
    }

    @Test
    void testStack() {
        Stack s = new Stack();
        s.printStack();
        assertEquals(null, s.pop());
        s.push("M");
        s.push("I");
        s.push("K");
        s.push("E");
        s.push("!");
        s.printStack();
        assertEquals("!", s.pop());
        s.printStack();
        assertEquals("M", s.search("M").getData());
        assertEquals(null, s.search("?"));
    }

    @Test
    void testEmptyQueue() {
        Queue q = new Queue();
        assertEquals(null, q.dequeue());
        q.printQueue();
        assertEquals(null, q.search("data"));
        q.enqueue(null);
        assertEquals(null, q.dequeue());
    }

    @Test
    void testQueue() {
        Queue q = new Queue();
        q.printQueue();
        q.enqueue("M");
        q.enqueue("i");
        q.enqueue("k");
        q.enqueue("e");
        q.printQueue();
        assertEquals("M", q.search("M").getData());
        assertEquals("e", q.search("e").getData());
        q.printQueue();
        assertEquals("M", q.dequeue());
        assertEquals("i", q.dequeue());
        assertEquals("k", q.dequeue());
        assertEquals("e", q.dequeue());
        assertEquals(null, q.dequeue());
    }
}
