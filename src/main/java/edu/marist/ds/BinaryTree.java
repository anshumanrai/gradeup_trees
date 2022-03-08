package edu.marist.ds;


class BTNode {

}

class BT {

	String inpFileName;

	public BT(String inInpFileName) {

		inpFileName = inInpFileName;

		System.out.println("BT: inpFileName : " + inpFileName);

		return;

	}


}

public class BinaryTree {

	public static void main (String args[]) {

		BT bt = new BT(args[0]);

		System.out.println("Running BinaryTree");

		return;

	}


}
