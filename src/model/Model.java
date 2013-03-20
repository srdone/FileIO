package model;

import java.util.ArrayList;
import java.io.Console;
import filehandlers.Reader;
import filehandlers.Writer;

/*
 * Keeps track of the data to write, the file names, etc.
 */
public class Model {
	private ArrayList<String> fileBuffer;
	private Writer writer;
	private Reader reader;

	public static final String INVALID_RESPONSE_TEXT = "That was not a valid response. Please enter (E), (S), (R), or (Q).";
	public static final String WELCOME_TEXT = "Welcome to FileIO. Please choose an option: " +
			"(E)nter Text\n" +
			"(S)ave File\n" +
			"(R)ead File\n" +
			"(Q)uit\n";
	public static final String REQUEST_LINE_OF_TEXT_TEXT = null;
	public static final String REQUEST_SAVE_FILE_NAME_TEXT = null;
	public static final String REQUEST_READ_FILE_NAME_TEXT = null;
	public static final String READ_FILE_SUCCESSFUL_TEXT = null;
	public static final String READ_FILE_FAILED_TEXT = null;
	public static final String QUIT_TEXT = null;
	
	/*
	 * Static method to read input from the user, in this case through the console.
	 */
	public static String getUserResponse() {
		return System.console().readLine();
	}
	
	/*
	 * Constructor - instantiates the fileBuffer, the writer, and the reader.
	 */
	public Model() {
		fileBuffer = new ArrayList<String>();
		writer = new Writer();
		reader = new Reader();
	}
	
	/*
	 * Uses the reader to read a file. If the file was read successfully (fileBuffer is not empty)
	 * then returns true, else returns false.
	 */
	public boolean readFile(String filename) {
		fileBuffer = reader.read(filename);
		if(fileBuffer.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Uses the writer to save a file. If the file was saved successfully, returns true. Else returns
	 * false
	 */
	public boolean saveFile(String filename) {
		return writer.save(filename);
	}

	/*
	 * Adds another string of text to the fileBuffer
	 */
	public void addText(String line) {
		fileBuffer.add(line);
	}
	
	public ArrayList<String> getFileBuffer() {
		return fileBuffer;
	}
	
	public void setFileBuffer(ArrayList<String> fileBuffer) {
		this.fileBuffer = fileBuffer;
	}

}
