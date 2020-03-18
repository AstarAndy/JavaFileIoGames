package com.acf.fileio.samples;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Pass-in a fully qualified file name as an argument.  If you
 * are going to pass-in a file name, use " and " if there are any spaces anywhere in the file name.
 * If you don't pass-in a file name, then the system will prompt for the entry of a file
 * @author andyfaust
 * @since 2020-03-15
 *
 */
public class FileGamesApp {

	// Just use built-in logging.  This is the professional way to print to the console
	// and there are no jar dependencies.
	private static final Logger log = Logger.getLogger(FileGamesApp.class.getName());
	
	public static void main(String[] args) {
		FileGamesApp fga = new FileGamesApp();
		fga.execute(args);

	}
	
	private void execute(String...args) {
		String fileToProcess = null;
		if (args.length > 0) {
			fileToProcess = args[0];
		} else {
			fileToProcess = getQualifiedFileName();
		}
		
		// If we still don't have a file name then we need to jet out-a-here
		log.info(String.format("The file name to process is '%s'", fileToProcess));
				
		if (fileToProcess.isEmpty()) {
			return;
		}
		
		// Validate that we have a valid file name or complain and exit
		
		
		
		return;
	}
	
	/**
	 * this method will be called if no file name was provided as an input argument to the class.
	 * It will prompt for a fully qualified file name and then return that input to the caller.
	 * @return String The fully qualified file name
	 */
	private String getQualifiedFileName() {
		
		String result = "";
		
		Scanner keyInput = new Scanner(System.in);
		
		System.out.print("\n Enter the qualifed file name to process.  Relatives are ok.  Just hit enter to stop: ");
		result = keyInput.nextLine();
		
		
		return result;
		
	}
	
	/**
	 * Simple method to validate the existence of a file using nio classes
	 * and static class methods
	 * @param qualifiedFileName 
	 * @throws FileNotFoundException If the file doesn't exist this error will be thrown
	 * @return boolean true if the file exists otherwise false.
	 */
	private boolean doesFileExist(String qualifiedFileName) throws FileNotFoundException {
		
		// First get a path object to where the file is.
		
		Path inWhichFolder = Paths.get(qualifiedFileName);
		
		boolean isFilePresent = (Files.exists(inWhichFolder) && Files.isReadable(inWhichFolder) && !Files.isDirectory(inWhichFolder));
		
		if (!isFilePresent) {
			throw new FileNotFoundException(String.format("The file you specified '%s' does not exist or cannot be found!", qualifiedFileName));
			
		}
		
		// If we're here then we should have a file that can be opened and read.
		
		return isFilePresent;
		
	}

}
