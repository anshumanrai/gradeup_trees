package edu.marist.ds;

import java.io.*;
import java.util.ArrayList;


class BTNode {

	String v;

	BTNode lc;

	BTNode rc;

	public BTNode (String iv) {

		v = new String(iv);

		lc = null;
		
		rc = null;

		return;

	}
	

}


class BTTree {

	BTNode r;

	public BTTree() {

		r = null;

		return;

	}

	public String search(String s) {


		String retVal = "";

		if (r == null) {

			return retVal;

		}

		else {

			boolean foundPos = false;

			BTNode cn = r;	

			while (!foundPos) {

				String cs = cn.v;	

				int ccr = s.compareTo(cs);

				if (ccr == 0) {

					retVal = s;
	
					foundPos = true;

				}

				else {

					if (ccr < 0) {

						if (cn.lc == null) {
	
							foundPos = true;

							System.out.println("Did not find the string " + s);

						}

						else {

							cn = cn.lc;

						}

					}



					else {

						if (cn.rc == null) {
	
							foundPos = true;

							System.out.println("Did not find the string " + s);

						}

						else {

							cn = cn.rc;

						}

					}


				}

			}

		}

		return retVal;


	}

	public void insert(String s) {

		if (r == null) {

			r = new BTNode(s);

		}

		else {

			boolean foundPos = false;

			BTNode cn = r;


			while (!foundPos) {

				String cs = cn.v;	

				int ccr = s.compareTo(cs);

				if (ccr == 0) {

					if (cn.lc == null) {
	
						foundPos = true;

						cn.lc = new BTNode(s);

					}

					else {

						cn = cn.lc;

					}

				}


				else {

					if (ccr < 0) {

						if (cn.lc == null) {
	
							foundPos = true;

							cn.lc = new BTNode(s);

							System.out.println("Inserting " + s + " in left tree of " + cn.v);

						}

						else {

							cn = cn.lc;

						}

					}



					else {

						if (cn.rc == null) {
	
							foundPos = true;

							cn.rc = new BTNode(s);

							System.out.println("Inserting " + s + " in right tree of " + cn.v);

						}

						else {

							cn = cn.rc;

						}

					}


				}


			}	


		}	

		return;

	}

	public String toString() {

		String retVal = "";

		if (r==null) {
			
			return retVal;
		}

		else {

			ArrayList currLevelNodes = new ArrayList<BTNode>();

			ArrayList nextLevelNodes;

			retVal = retVal + r.v + "\n";

			if (!(r.lc == null)) {
				
				currLevelNodes.add(r.lc);

			}

			if (!(r.rc == null)) {
				
				currLevelNodes.add(r.rc);

			}

			int clns = currLevelNodes.size();

			BTNode cn;

			while (clns > 0) {

				int i;

				for(i=0;i<(clns-1);i++) {

					cn = (BTNode)currLevelNodes.get(i);

					retVal = retVal + cn.v + " , ";

				}

				cn = (BTNode)currLevelNodes.get(i);

				retVal = retVal + cn.v + "\n";

				nextLevelNodes = new ArrayList<BTNode>();

				for(i=0;i<clns;i++) {

					cn = (BTNode)currLevelNodes.get(i);

					if (!(cn.lc == null)) {

						nextLevelNodes.add(cn.lc);

					}

					if (!(cn.rc == null)) {

						nextLevelNodes.add(cn.rc);

					}

				}

				currLevelNodes = nextLevelNodes;

				clns = currLevelNodes.size();


			}

		}

		return retVal;

	}

}


class BT {

	String inpFileName;

	ArrayList<String> inpStrings;

	BTTree btt;

	public BTTree delete(String delvar) {

		ArrayList<String> currInpStrings = new ArrayList<String>();

		int iss = inpStrings.size();

		int i;

		for(i=0;i<iss;i++) {

			String cs = inpStrings.get(i);

			if (!cs.equals(delvar)) {

				currInpStrings.add(cs);
				
			}

		}

		BTTree cbtt = createBinaryTreeFromList(currInpStrings);

		return cbtt;


	}

	public BTTree createBinaryTreeFromList(ArrayList<String> sa) {

		BTTree cbtt = new BTTree();

		int sas = sa.size();

		int i;
		
		for(i=0;i<sas;i++) {

			String cs = sa.get(i);

			cbtt.insert(cs);

		}	

		return cbtt;

	}

	public void createBinaryTree() {

		btt = new BTTree();

		int iss = inpStrings.size();

		int i;
		
		for(i=0;i<iss;i++) {

			String cs = inpStrings.get(i);

			btt.insert(cs);

		}	

		return;

	} 

	public String search(String s) {

		String retVal = btt.search(s);

		return retVal;

	}

	public void printBinaryTree() {

		System.out.println("Printing Binary Tree");

		System.out.println(btt.toString());

		return;

	}

	public void readInputFile() {

		try {
		  
			File file=new File(inpFileName);    //creates a new file instance  

			FileReader fr=new FileReader(file);   //reads the file  

			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  

			String line;  

			while((line=br.readLine())!=null)  
			{  

				System.out.println(line);

				inpStrings.add(line);
			
			}  

			fr.close();    //closes the stream and release the resources  
		}  
		catch(IOException e)  
		{  

			e.printStackTrace();  

		}  

		return;

	}	

	public BT(String inInpFileName) {

		inpFileName = inInpFileName;

		inpStrings = new ArrayList<String>();

		System.out.println("BT: inpFileName : " + inpFileName);

		return;

	}


}

public class BinaryTree {

	public static void main (String args[]) {

		BT bt = new BT(args[0]);

		bt.readInputFile();

		bt.createBinaryTree();

		bt.printBinaryTree();

		System.out.println("Running BinaryTree");

		String searchString = "Icecream";

		System.out.println("Searching string " + searchString);

		String searchResult = bt.search(searchString);

		int cv = searchResult.compareTo(searchString);

		if (cv == 0) {

			System.out.println("Found search string " + searchString);

		}

		else {

			System.out.println("Could not find string  " + searchString); 

		}

		searchString = "Cookie";

		System.out.println("Searching string " + searchString);

		searchResult = bt.search(searchString);

		cv = searchResult.compareTo(searchString);

		if (cv == 0) {

			System.out.println("Found search string " + searchString);

		}

		else {

			System.out.println("Could not find string  " + searchString); 

		}

		String delString = "Soap";

		System.out.println("Deleting string " + delString);

		BTTree dt = bt.delete(delString);

		System.out.println("Tree after deletion of " + delString);

		System.out.println(dt.toString());

		return;

	}


}
