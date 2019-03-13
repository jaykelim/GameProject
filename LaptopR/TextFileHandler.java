package LaptopR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileHandler implements TextFileIOer{
	
	public void createNewFile(String fileName){
		PrintWriter outStream =null;//use the PrintWriter to create our output stream
		try {
			outStream = new PrintWriter(fileName);//create & connect the output stream to the file using the String fileName
			System.out.println("Successfully created the file "+fileName);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			System.out.println("Inside createNewFile method problem creating the file "+fileName);
		}
		finally{
			if(outStream != null){//if not closed
				outStream.close(); //close it
			}
			System.out.println("All done with createNewFile method");
		}
	}
	

	public void writeToNewFile(String fileName, String fileContent){
		PrintWriter outStream =null;//use the PrintWriter to create our output stream
		try {
			outStream = new PrintWriter(fileName);//create & connect the output stream to the file using the String fileName
			outStream.println(fileContent);//write the String to the file
			System.out.println("Successfully wrote to the file "+fileName);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			System.out.println("Inside writeToNewFile method problem creating/write the file "+fileName);
		}
		finally{
			if(outStream != null){//if not closed
				outStream.close(); //close it
			}
			System.out.println("All done with writeToNewFile method");
		}
	}
	
	public void appendToFile(String fileName, String fileContent){
		PrintWriter outStream =null;//use the PrintWriter to create our output stream
		try {
//			outStream = new PrintWriter(fileName);//create & connect the output stream to the file using the String fileName
			FileOutputStream fileOut = new FileOutputStream(fileName, true);//create FileOutputStream ans specify true to APPEND
			outStream = new PrintWriter(fileOut);//connect to the file output stream
			outStream.println(fileContent);//write the String to the file
			System.out.println("Successfully wrote to the file "+fileName);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			System.out.println("Inside writeToNewFile method problem creating/write the file "+fileName);
		}
		finally{
			if(outStream != null){//if not closed
				outStream.close(); //close it
			}
			System.out.println("All done with writeToNewFile method");
		}
	}
	
	public String read1LineFromFile(String fileName){
		String fileContents = "";
		Scanner inputStream = null;
		try {
			File theFile = new File(fileName);//create a File object using the String fileName and the File constructor
			inputStream = new Scanner(theFile);//connect my input stream to the FILE
			fileContents = inputStream.nextLine();//read in 1 line from the file 
			
		} catch (FileNotFoundException e) {
			System.err.println("Inside read1LineFromFile could not read from " + fileName + 
					"\nthe message was: " + e.getMessage());
//			e.printStackTrace();
		}
		finally{
			if(inputStream != null){
				inputStream.close();
			}
		}
		return fileContents;
	}
	
	public String readPlayerFromFile1(String fileName){
		String fileContents = "";
		Scanner inputStream = null;
		try {
			File theFile = new File(fileName);//create a File object using the String fileName and the File constructor
			inputStream = new Scanner(theFile);//connect my input stream to the FILE
			fileContents = inputStream.nextLine();//read in 1 line from the file 
			
		} catch (FileNotFoundException e) {
			System.err.println("Inside read1LineFromFile could not read from " + fileName + 
					"\nthe message was: " + e.getMessage());
//			e.printStackTrace();
		}
		finally{
			if(inputStream != null){
				inputStream.close();
			}
		}
		return fileContents;
	}



	@Override
	public String readFile(String fileName) {
		String fileContents = "";
		Scanner inputStream = null;
		try {
			File theFile = new File(fileName);//create a File object using the String fileName and the File constructor
			inputStream = new Scanner(theFile);//connect my input stream to the FILE
			while(inputStream.hasNextLine()){
				fileContents += inputStream.nextLine() +"\n";//read in 1 line from the file 
			}
		} catch (FileNotFoundException e) {
			System.err.println("Inside readFile could not read from " + fileName + 
					"\nthe message was: " + e.getMessage());
//			e.printStackTrace();
		}
		finally{
			if(inputStream != null){
				inputStream.close();
			}
		}
		return fileContents;
	}
	


	@Override
	public String readDelimetedFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean copyFile(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean copyFile(String fileName1, String fileName2) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean deleteFile(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
