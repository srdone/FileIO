package model;

import java.util.ArrayList;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import filehandlers.Reader;
import filehandlers.Writer;

/*
 * Keeps track of the data to write, the file names, etc.
 */
public class Model {
	private ArrayList<String> fileBuffer;
	private Writer writer;
	private Reader reader;
	private File currentFile;

	public static final String INVALID_RESPONSE_TEXT = "That was not a valid response. Please enter (E), (S), (R), or (Q).";
	public static final String WELCOME_TEXT = "Welcome to FileIO. Please choose an option: ";
	public static final String REQUEST_LINE_OF_TEXT_TEXT = "Please enter text to be saved in file. \n" +
			"When you are done, hit enter without typing text on the blank line.";
	public static final String REQUEST_FILE_NAME_TEXT = "Please enter the name of your file.";
	public static final String READ_FILE_SUCCESSFUL_TEXT = "The file was successfully read.";
	public static final String READ_FILE_FAILED_TEXT = "The file read failed.";
	public static final String QUIT_TEXT = "Thank you for using FileIO. Exiting.";
	public static final String INPUT_COMPLETE_TEXT = "File Input Complete";
	public static final String UNABLE_TO_CREATE_FILE = "Cannot read file.";
	public static final String UNABLE_TO_READ_FILE = "Cannot read file.";
	
	/*
	 * Constructor - instantiates the fileBuffer, the writer, and the reader.
	 */
	public Model() {
		fileBuffer = new ArrayList<String>();
		writer = new Writer(this);
		reader = new Reader(this);
	}
	
	public void setCurrentFile(File file) {
		currentFile = file;
	}
	
	/*
	 * Returns the current file
	 */
	public File getCurrentFile() {
		return currentFile;
	}

	/*
	 * Adds another string of text to the fileBuffer
	 */
	public void addTextToFileBuffer(String line) {
		fileBuffer.add(line);
	}
	
	public ArrayList<String> getFileBuffer() {
		return fileBuffer;
	}
	
	public void setFileBuffer(ArrayList<String> fileBuffer) {
		this.fileBuffer = fileBuffer;
	}

}
