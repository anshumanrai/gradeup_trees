package edu.marist.ds;

import edu.marist.ds.Queue;
import edu.marist.ds.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main app class.
 */
public final class App {
    protected App() {
    }

    /**
     * Says hello to the world!
     * @param args The arguments of the program.
     */
    /*public static void main(String[] args) {
        int returnCode = 0;
        Utils utils = new Utils();
        utils.processArgs(args);
        System.out.println("Hello World!");
        System.exit(returnCode);
    }*/

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(args[0]));
        Stack stack = new Stack();
        Queue queue = new Queue();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();

            if (!line.isEmpty()) {

                for (char c : line.toCharArray()) {
                    String character = String.valueOf(c);
                    stack.push(character);
                    queue.enqueue(character);
                }

                if (stack.pop().equals(queue.dequeue())) { 
									System.out.println("printing line: " + line); 
								}
                stack.clear();
                queue.clear();
            }
        }

        scanner.close();
    }

    /**
     * Says hello to the world!
     * @param inString The arguments of the program.
     */
    public static String everyOtherLine(String inString) {
        String[] inStringLineArray = inString.split("\n");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < inStringLineArray.length) {
            sb.append(inStringLineArray[i]);
            sb.append("\n");
            i = i + 2;
        }
        return sb.toString();
    }
}
