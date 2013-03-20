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
		String response = Model.getUserResponse();
		return processResponse(response);
	}
	
	/*
	 * Take lines of text until there is a blank line.
	 */
	public void enterText() {
		String line = "";
		while(!line.equals("")) {
			line = requestLineOfText();
			model.addText(line);
		}
		runApp();
	}
	
	private String requestLineOfText() {
		System.out.println(Model.REQUEST_LINE_OF_TEXT_TEXT);
		return Model.getUserResponse();
	}

	/*
	 * Take save text in model to a file specified by the user.
	 */
	public void saveFile() {
		String filename = getSaveFileName();
		model.saveFile(filename);
		runApp();
	}
	
	/*
	 * Ask the user for the name of the file they want to open
	 */
	private String getSaveFileName() {
		System.out.println(Model.REQUEST_SAVE_FILE_NAME_TEXT);
		return Model.getUserResponse();
	}

	/*
	 * Read the contents of a file into the model
	 */
	public void readFile() {
		String filename = getReadFileName();
		if(model.readFile(filename)) {
			System.out.println(Model.READ_FILE_SUCCESSFUL_TEXT);
		} else {
			System.out.println(Model.READ_FILE_FAILED_TEXT);
		}
		runApp();
	}
	
	/*
	 * Ask the user what they want to save the file as.
	 */
	private String getReadFileName() {
		System.out.println(Model.REQUEST_READ_FILE_NAME_TEXT);
		return Model.getUserResponse();
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

}
