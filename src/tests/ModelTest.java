package tests;

import java.io.File;
import java.util.ArrayList;

import model.Model;

public class ModelTest {

		Model model;
		
		public ModelTest() {
			model = new Model();
		}
		
		public boolean runTests() {
			boolean testOutcome = true;
			testOutcome = testFile();
			testOutcome = testLoadFileBuffer();
			testOutcome = testReplaceFileBuffer();
			String string = (testOutcome) ? "Model test successful" : "Model test failed";
			print(string);
			return testOutcome;
		}
		
		private boolean testFile() {
			File myFile1 = new File("My File");
			model.setCurrentFile(myFile1);
			File myFile2 = model.getCurrentFile();
			if(myFile1 == myFile2) {
				System.out.println("testFile successful");
				return true;
			} else {
				System.out.println("testFile failed");
				return false;
			}
		}
		
		private boolean testLoadFileBuffer() {
			//Initialize variables
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			String line1 = "Line 1";
			String line2 = "Line 2";
			//Load file buffer
			model.addTextToFileBuffer(line1);
			model.addTextToFileBuffer(line2);
			//Load comparison ArrayList
			list2.add(line1);
			list2.add(line2);
			//get loaded ArrayList
			list1 = model.getFileBuffer();
			//Compare
			boolean result = list1.equals(list2);
			String string = (result) ? "Load FileBuffer test successful" : "Load FileBuffer test failed";
			print(string);
			return result;
		}
		
		private boolean testReplaceFileBuffer() {
			//Initialize variables
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			String line1 = "Line 1";
			String line2 = "Line 2";
			String line3 = "Line 3";
			//Load comparison ArrayList
			list2.add(line1);
			list2.add(line2);
			//Load file buffer
			model.addTextToFileBuffer(line1);
			model.addTextToFileBuffer(line3);
			//Replace file buffer
			model.setFileBuffer(list2);
			list1 = model.getFileBuffer();
			//Compare
			boolean result = list1.equals(list2);
			String string = (result) ? "Replace FileBuffer test successful" : "Replace FileBuffer test failed";
			print(string);
			return result;
		}
		
		private void print(String string) {
			System.out.println(string);
		}

}
