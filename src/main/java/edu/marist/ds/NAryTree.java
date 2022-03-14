package edu.marist.ds;

import java.io.*;
import java.util.ArrayList;


class NAryBTNode {

	String v;

	NAryBTNode lc;

	NAryBTNode rc;

	public NAryBTNode (String iv) {

		v = new String(iv);

		lc = null;
		
		rc = null;

		return;

	}
	

}


class NAryBTTree {

	NAryBTNode r;

	public NAryBTTree() {

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

			NAryBTNode cn = r;	

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

			r = new NAryBTNode(s);

		}

		else {

			boolean foundPos = false;

			NAryBTNode cn = r;


			while (!foundPos) {

				String cs = cn.v;	

				int ccr = s.compareTo(cs);

				if (ccr == 0) {

					if (cn.lc == null) {
	
						foundPos = true;

						cn.lc = new NAryBTNode(s);

					}

					else {

						cn = cn.lc;

					}

				}


				else {

					if (ccr < 0) {

						if (cn.lc == null) {
	
							foundPos = true;

							cn.lc = new NAryBTNode(s);

							System.out.println("Inserting " + s + " in left tree of " + cn.v);

						}

						else {

							cn = cn.lc;

						}

					}



					else {

						if (cn.rc == null) {
	
							foundPos = true;

							cn.rc = new NAryBTNode(s);

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

			ArrayList currLevelNodes = new ArrayList<NAryBTNode>();

			ArrayList nextLevelNodes;

			retVal = retVal + r.v + "\n";

			if (!(r.lc == null)) {
				
				currLevelNodes.add(r.lc);

			}

			if (!(r.rc == null)) {
				
				currLevelNodes.add(r.rc);

			}

			int clns = currLevelNodes.size();

			NAryBTNode cn;

			while (clns > 0) {

				int i;

				for(i=0;i<(clns-1);i++) {

					cn = (NAryBTNode)currLevelNodes.get(i);

					retVal = retVal + cn.v + " , ";

				}

				cn = (NAryBTNode)currLevelNodes.get(i);

				retVal = retVal + cn.v + "\n";

				nextLevelNodes = new ArrayList<NAryBTNode>();

				for(i=0;i<clns;i++) {

					cn = (NAryBTNode)currLevelNodes.get(i);

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


class NAryBT {

	String inpFileName;

	ArrayList<String> inpStrings;

	NAryBTTree btt;

	public NAryBTTree delete(String delvar) {

		ArrayList<String> currInpStrings = new ArrayList<String>();

		int iss = inpStrings.size();

		int i;

		for(i=0;i<iss;i++) {

			String cs = inpStrings.get(i);

			if (!cs.equals(delvar)) {

				currInpStrings.add(cs);
				
			}

		}

		NAryBTTree cbtt = createBinaryTreeFromList(currInpStrings);

		return cbtt;


	}

	public NAryBTTree createBinaryTreeFromList(ArrayList<String> sa) {

		NAryBTTree cbtt = new NAryBTTree();

		int sas = sa.size();

		int i;
		
		for(i=0;i<sas;i++) {

			String cs = sa.get(i);

			cbtt.insert(cs);

		}	

		return cbtt;

	}

	public void createBinaryTree() {

		btt = new NAryBTTree();

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

	public NAryBT(String inInpFileName) {

		inpFileName = inInpFileName;

		inpStrings = new ArrayList<String>();

		System.out.println("NAryBT: inpFileName : " + inpFileName);

		return;

	}


}

public class NAryTree {

	public static void main (String args[]) {

		NAryBT bt = new NAryBT(args[0]);

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

		NAryBTTree dt = bt.delete(delString);

		System.out.println("Tree after deletion of " + delString);

		System.out.println(dt.toString());

		return;

	}


}
