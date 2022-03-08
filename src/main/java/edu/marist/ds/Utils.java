
package edu.marist.ds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.marist.ds.CONSTANTS;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * General utilty and helper methods.
 */
public class Utils {
    /**
     * Print help text.
     * @param options CLI options to print
     */
    public void printHelpText(Options options) {
        System.out.println(CONSTANTS.getAppName());
        System.out.println("Version: " + CONSTANTS.getVersion());

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(CONSTANTS.getAppName(), options);
    }

    /**
     * Initialize CLI options.
     * @return Options of CLI for use in parser
     */
    public Options initOptions() {
        Options options = new Options();
        options.addOption("v", false, "Verbose mode");
        options.addOption("h", false, "Display this help text");
        options.addOption("t", false, "This is america project");
        return options;
    }

    /**
     * Process command line arguments using Apache Commons CLI.
     * @param args Arguments from command line
     * @return Parsed command line output
     */
    public CommandLine processArgs(String[] args) {
        Options options = initOptions();

        CommandLineParser parser = new PosixParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException pe) {
            printHelpText(options);
            error("Error parsing command line: " + pe.getMessage());
        }

        if (cmd.hasOption("h")) {
            printHelpText(options);
            System.exit(0);
        } else if (cmd.hasOption("v")) {
            System.out.println("Verbose mode");
            System.out.println(CONSTANTS.getAppName() + " version: " + CONSTANTS.getVersion());
        } else if (cmd.hasOption("t")) {
            System.out.println("This is america project");
            System.out.println(CONSTANTS.getAppName() + " version: " + CONSTANTS.getVersion());
        }
        return cmd;

    }

    /**
     * Error helper method to print error message to stderr and exit with return code.
     * @param msg Error message to be printed
     * @param returnCode Return code to exit with
     */
    public void error(String msg, int returnCode) {
        System.err.println(msg);
        System.exit(returnCode);
    }

    /**
     * Error helper method to print error message to stderr and exit with return code -1.
     * @param msg Error message to be printed
     */
    public void error(String msg) {
        System.err.println(msg);
        System.exit(-1);
    }

    /**
     * Open file based on file name and retrun content string.
     * @param filename Name of the file to open
     * @return String content read from file
     */
    public String readFile(String filename) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                builder.append("\n");
                line = reader.readLine();
            }
            return builder.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return builder.toString();
    }

}
