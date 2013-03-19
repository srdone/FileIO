package ui.application;

import model.Model;
import enums.MenuOptions;

/*
 * Creates the main interface for the application, consisting of a menu that offers the user four choices:
 * (E)nter text
 * (S)ave text
 * (R)ead text
 * (Q)uit
 */
public class FileIO {
	Model model = new Model();
	
	/*
	 * Initialize and launch menu
	 */
	public FileIO() {
		
	}
	
	/*
	 * Creates the menu and produces the actions requested by the user.
	 */
	private void runApp() {
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
	private void enterText() {
		String line;
		while(!line.equals("")) {
			line = requestLineOfText();
			model.addText(line);
		}
		runApp();
	}
	
	private String requestLineOfText() {
		System.out.println(Model.REQUEST_LINE_OF_TEXT_TEXT);
		//TODO
		return null;
	}

	/*
	 * Take save text in model to a file specified by the user.
	 */
	private void saveFile() {
		String filename = 
		model.saveFile(filename);
		runApp();
	}
	
	/*
	 * Read the contents of a file into the model
	 */
	private void readFile() {
		//TODO
		runApp();
	}
	
	/*
	 * Exit the application
	 */
	private void quit() {
		//TODO
		runApp();
	}
	
	/*
	 * Print text letting the user know that they entered an invalid response.
	 */
	private void notAValidResponse() {
		printInvalidResponseText();
		runApp();
	}
	
	/*
	 * Print the invalid response text
	 */
	private void printInvalidResponseText() {
		System.out.println(Model.INVALID_RESPONSE_TEXT);
	}
	
	/*
	 * Write the text menu to the console.
	 */
	private void writeMenu() {
		printWelcomeText();
		printMenuItems();
	}
	
	/*
	 * Print the text preceeding the actual menu options.
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
	 * Allow the user to respond in the console and read that response.
	 */
	private String getUserResponse() {
		//TODO
	}
	
	/*
	 * Processes the string response into a MenuOptions enumerated value
	 */
	public MenuOptions processResponse(String response) {
		return MenuOptions.getMatchingOption(response.charAt(0));
	}

}
