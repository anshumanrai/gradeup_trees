package edu.marist.ds;

import java.io.*;
import java.util.ArrayList;


class BTNode {

}

class BT {

	String inpFileName;

	ArrayList<String> inpStrings;

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

		System.out.println("Running BinaryTree");

		return;

	}


}
