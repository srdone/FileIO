package filehandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import model.Model;

/*
 * Provides file reading functionality
 */
public class Reader {
	Model model;
	
	/*
	 * Reader constructor
	 */
	public Reader(Model m) {
		model = m;
	}

	/**
	 * Reads the data in the filename and returns it as an ArrayList of Strings - one string per line.
	 * If the file is blank, returns an empty ArrayList<String>.
	 * @param filename The name and path of the file to be read.
	 * @return Returns an ArrayList<String> with the data read from the file
	 * @throws InvocationTargetException 
	 */
	public boolean read() {
		// TODO Auto-generated method stub
		ArrayList<String> fileBuffer = new ArrayList<String>();
		try{
			fileBuffer = readFile();
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * Reads the currentFile from model into an ArrayList, and returns that arrayList.
	 */
	private ArrayList<String> readFile() throws InvocationTargetException {
		FileReader fReader;
		BufferedReader bReader;
		ArrayList<String> fileBuffer = new ArrayList<String>();
		String line = "";
		try {
			fReader = new FileReader(model.getCurrentFile());
			bReader = new BufferedReader(fReader);
			while((line = bReader.readLine()) != null) {
				fileBuffer.add(line);
			}
		} catch (IOException e) {
			throw new InvocationTargetException(e);
		}
		return fileBuffer;
	}

}
