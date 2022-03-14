package edu.marist.ds;

import java.io.*;
import java.util.ArrayList;


class AVLBTNode {

	String v;

	AVLBTNode lc;

	AVLBTNode rc;

	public AVLBTNode (String iv) {

		v = new String(iv);

		lc = null;
		
		rc = null;

		return;

	}
	

}


class AVLBTTree {

	AVLBTNode r;

	public AVLBTTree() {

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

			AVLBTNode cn = r;	

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

			r = new AVLBTNode(s);

		}

		else {

			boolean foundPos = false;

			AVLBTNode cn = r;


			while (!foundPos) {

				String cs = cn.v;	

				int ccr = s.compareTo(cs);

				if (ccr == 0) {

					if (cn.lc == null) {
	
						foundPos = true;

						cn.lc = new AVLBTNode(s);

					}

					else {

						cn = cn.lc;

					}

				}


				else {

					if (ccr < 0) {

						if (cn.lc == null) {
	
							foundPos = true;

							cn.lc = new AVLBTNode(s);

							System.out.println("Inserting " + s + " in left tree of " + cn.v);

						}

						else {

							cn = cn.lc;

						}

					}



					else {

						if (cn.rc == null) {
	
							foundPos = true;

							cn.rc = new AVLBTNode(s);

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

			ArrayList currLevelNodes = new ArrayList<AVLBTNode>();

			ArrayList nextLevelNodes;

			retVal = retVal + r.v + "\n";

			if (!(r.lc == null)) {
				
				currLevelNodes.add(r.lc);

			}

			if (!(r.rc == null)) {
				
				currLevelNodes.add(r.rc);

			}

			int clns = currLevelNodes.size();

			AVLBTNode cn;

			while (clns > 0) {

				int i;

				for(i=0;i<(clns-1);i++) {

					cn = (AVLBTNode)currLevelNodes.get(i);

					retVal = retVal + cn.v + " , ";

				}

				cn = (AVLBTNode)currLevelNodes.get(i);

				retVal = retVal + cn.v + "\n";

				nextLevelNodes = new ArrayList<AVLBTNode>();

				for(i=0;i<clns;i++) {

					cn = (AVLBTNode)currLevelNodes.get(i);

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


class AVLBT {

	String inpFileName;

	ArrayList<String> inpStrings;

	AVLBTTree btt;

	public AVLBTTree delete(String delvar) {

		ArrayList<String> currInpStrings = new ArrayList<String>();

		int iss = inpStrings.size();

		int i;

		for(i=0;i<iss;i++) {

			String cs = inpStrings.get(i);

			if (!cs.equals(delvar)) {

				currInpStrings.add(cs);
				
			}

		}

		AVLBTTree cbtt = createBinaryTreeFromList(currInpStrings);

		return cbtt;


	}

	public AVLBTTree createBinaryTreeFromList(ArrayList<String> sa) {

		AVLBTTree cbtt = new AVLBTTree();

		int sas = sa.size();

		int i;
		
		for(i=0;i<sas;i++) {

			String cs = sa.get(i);

			cbtt.insert(cs);

		}	

		return cbtt;

	}

	public void createBinaryTree() {

		btt = new AVLBTTree();

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

	public AVLBT(String inInpFileName) {

		inpFileName = inInpFileName;

		inpStrings = new ArrayList<String>();

		System.out.println("AVLBT: inpFileName : " + inpFileName);

		return;

	}


}

public class AVLTree {

	public static void main (String args[]) {

		AVLBT bt = new AVLBT(args[0]);

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

		AVLBTTree dt = bt.delete(delString);

		System.out.println("Tree after deletion of " + delString);

		System.out.println(dt.toString());

		return;

	}


}
