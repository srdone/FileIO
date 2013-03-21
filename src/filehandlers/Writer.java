package filehandlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import model.Model;

/*
 * Provides file writing functionality.
 */
public class Writer {
	boolean success;
	Model model;
	
	public Writer(Model m) {
		model = m;
		success = false;
	}

	/*
	 * Saves the lines in Model's fileBuffer to the specified filename, which can include the path.
	 * Returns a true or false depending on whether the save was successful.
	 * Prints the specific issue to the console.
	 */
	public boolean save() throws InvocationTargetException {
		success = false;
		writeDataToFile();
		return false;
	}

	private boolean writeDataToFile() throws InvocationTargetException {
		boolean successFlag = true;
		for(String string : model.getFileBuffer()) {
			boolean stepFlag = printToFile(string, true, true);
			//Set successFlag to false if there is even one failure
			if(stepFlag == false) successFlag = false;
		}
		return successFlag;
	}

	public boolean printToFile(String text, boolean append, boolean autoFlush) throws InvocationTargetException {
		FileWriter fWriter;
		PrintWriter pWriter;
		boolean successFlag = true;
		try {
			fWriter = new FileWriter(model.getCurrentFile(), append);
		} catch (IOException e) {
			throw new InvocationTargetException(e);
		}
		pWriter = new PrintWriter(fWriter, autoFlush);

		pWriter.println(text);

		if (pWriter.checkError()) {
			successFlag = false;
		}
		//The file streams should close and flush on method exit
		//but to be safe, always explicity close();
		pWriter.close();

		return successFlag;
	}

	

}
