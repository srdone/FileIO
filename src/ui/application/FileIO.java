package ui.application;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import model.Model;
import enums.MenuOptions;
import filehandlers.Reader;
import filehandlers.Writer;

/*
 * Creates the main interface for the application, consisting of a menu that offers the user four choices:
 * (E)nter text
 * (S)ave text
 * (R)ead text
 * (Q)uit
 */
public class FileIO {
	Model model;
	Reader r;
	Writer w;
	
	/*
	 * Initialize and launch menu
	 */
	public FileIO() {
		model = new Model();
		r = new Reader(model);
		w = new Writer(model);
	}
	
	/*
	 * Creates the menu and produces the actions requested by the user.
	 */
	public void runApp() {
		switch(getMenuResponse()) {
		case ENTER: enterText(); break;
		case SAVE: saveFile(); break;
		case READ: readFile(); break;
		case QUIT: quit(); break;
		default: notAValidResponse(); break;
		}
	}

	/*
	 * Write the menu, get the response from the user, process it into a MenuOptions enumerated value.
	 */
	private MenuOptions getMenuResponse() {
		writeMenu();
		String response = getUserResponse();
		return processResponse(response);
	}
	
	/*
	 * Take lines of text until there is a blank line.
	 */
	public void enterText() {
		String line = "";
		while(!line.equals("")) {
			line = requestLineOfText();
			model.addTextToFileBuffer(line);
		}
		runApp();
	}
	
	private String requestLineOfText() {
		System.out.println(Model.REQUEST_LINE_OF_TEXT_TEXT);
		return getUserResponse();
	}

	/*
	 * Take save text in model to a file specified by the user.
	 */
	public void saveFile() {
		String filename = getFileName();
		try {
			File file = createFile(filename);
			model.setCurrentFile(file);
			w.save();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		runApp();
	}

	/*
	 * Read the contents of a file into the model
	 */
	public void readFile() {
		String filename = getFileName();
		try {
			model.setCurrentFile(createFile(filename));
			r.read();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		runApp();
	}
	
	/*
	 * Ask the user what they want to save the file as.
	 */
	private String getFileName() {
		System.out.println(Model.REQUEST_FILE_NAME_TEXT);
		return getUserResponse();
	}
	
	/*
	 * Exit the application
	 */
	public void quit() {
		System.out.println(Model.QUIT_TEXT);
		System.exit(0);
	}
	
	/*
	 * Print text letting the user know that they entered an invalid response.
	 */
	private void notAValidResponse() {
		System.out.println(Model.INVALID_RESPONSE_TEXT);
		runApp();
	}
	
	/*
	 * Write the text menu to the console.
	 */
	private void writeMenu() {
		printWelcomeText();
		printMenuItems();
	}
	
	/*
	 * Print the text preceding the actual menu options.
	 */
	private void printWelcomeText() {
		System.out.println(Model.WELCOME_TEXT);
	}
	
	/*
	 * Print the menu options
	 */
	private void printMenuItems() {
		for(MenuOptions option : MenuOptions.values()) {
		System.out.println(option.getMenuName());
		}
	}
	
	/*
	 * Processes the string response into a MenuOptions enumerated value
	 */
	public MenuOptions processResponse(String response) {
		return MenuOptions.getMatchingOption(response.charAt(0));
	}
	
	/*
	 * Create the directories and the file specified by filename
	 * Does not write anything to the file
	 */
	private File createFile(String filename) throws InvocationTargetException{
		// TODO Auto-generated method stub
		//Create new file
		File myFile = new File(filename);
		//Save the file
		try {
			File directoryFile = myFile.getParentFile();
			//Create directories
			if(directoryFile != null) {
				directoryFile.mkdirs();
			}
			myFile.createNewFile();
		} catch (IOException e) {
			throw new InvocationTargetException(e);
		}
		return myFile;
	}
	
	/*
	 * Static method to read input from the user, in this case through the console.
	 */
	public String getUserResponse() {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		return s;
	}

}
